# libraries
import PyPDF2
import json
import os, fnmatch
import math

# constants
F_DATABASE_DIR        = "database"
F_ANALYSIS_DIR        = "analysis"
F_PROFILE_NOME        = "nome"
F_PROFILE_AFASTAMENTO = "afastamento"
F_PROFILE_REGIME      = "regime"
F_RETURN_TRUE         = "Y"
F_RETURN_FALSE        = "N"

#parameters
parameter = {
      "HD"     :  {"20h" :   8.00 , "40h" :   8.00 }
     ,"PAE"    :  {"20h" :  20.00 , "40h" : 150.00 }
     ,"PAP"    :  {"20h" :  13.00 , "40h" :  90.00 }
     ,"PAC"    :  {"20h" :   5.00 , "40h" :  20.00 }
     ,"PERCEN" :  {"20h" :   0.85 , "40h" :   0.85 }
     ,"QUALIF" :  {"20h" :  72.00 , "40h" :  72.00 }
}

# activities
activity = {
      "I"     : "ATIVIDADES DE ENSINO"
    , "I-1"   : "... Ensino de graduação"
    , "I-2"   : "... Ensino de pós-graduação"
    , "I-3"   : "... Projetos de Ensino"
    , "II"    : "PRODUÇÃO INTELECTUAL"
    , "II-1"  : "... Produção Científica"
    , "II-2"  : "... Produção Artística e Cultural"
    , "II-3"  : "... Produção Técnica ou Tecnológica"
    , "II-4"  : "... Outro Tipo de Produção"
    , "III"   : "ATIVIDADES DE PESQUISA E DE EXTENSÃO"
    , "III-1" : "... Atividades de Pesquisa"
    , "III-2" : "... Atividades de Extensão"
    , "IV"    : "ATIVIDADES ADMINISTRATIVAS E DE REPRESENTAÇÃO"
    , "IV-1"  : "... Direção e Função Gratificada"
    , "IV-2"  : "... Atividades Administrativas"
    , "IV-3"  : "... Outras Atividades Administrativas"
    , "IV-4"  : "... Atividades de Representação Fora da UFG"
    , "V"     : "OUTRAS ATIVIDADES"
    , "V-1"   : "... Atividades Acadêmicas – Orientação"
    , "V-2"   : "... Atividades Acadêmicas – Bancas e Cursos"
    , "V-3"   : "... Atividades de Aprendizado e Aperfeiçoamento"
}

def getFile(pattern, path):
    result = []
    for root, dirs, files in os.walk(path):
        for name in files:
            if fnmatch.fnmatch(name, pattern):
                result.append(os.path.join(root, name))
    return result

def getSum (professor, items):
    list = items.split(";")
    sum = 0
    for x in list:
        sum += professor[x] if x in professor else 0.0
    return sum

def getAFAST (professor):
    tempo = professor[F_PROFILE_AFASTAMENTO] if F_PROFILE_AFASTAMENTO in professor else 0
    if (tempo > 360):
       return 12
    else:
       return math.ceil(tempo/30)

def getHR (professor):
    meses = getAFAST(professor)
    if (meses == 0):
       return getSum(professor, "I-1;I-2") / 20
    else:
       return getSum(professor, "I-1;I-2") * 12 / ( meses * 20 )

def getPAE (professor):
    return getSum(professor, "I-3;II;III;IV;V")

def getPAC (professor):
    return getSum(professor, "I-3;III-2;IV-2;IV-3;IV-4")

def getPAP (professor):
    return getSum(professor, "II;III-1;V-1")

def getQUALIF (professor):
    return getSum(professor, "V-3-1;V-3-2")

def analyzeArticle06 (professor):
    if (getPAE(professor) < parameter["PAE"][professor[F_PROFILE_REGIME]]):
       return F_RETURN_FALSE
    if (getPAP(professor) >= parameter["PAP"][professor[F_PROFILE_REGIME]]):
       return F_RETURN_TRUE
    if (getPAC(professor) >= parameter["PAC"][professor[F_PROFILE_REGIME]]):
       return F_RETURN_TRUE
    if (getPAC(professor) + getPAP(professor)) >= (parameter["PERCEN"][professor[F_PROFILE_REGIME]] * (parameter["PAC"][professor[F_PROFILE_REGIME]] + parameter["PAP"][professor[F_PROFILE_REGIME]])):
       return F_RETURN_TRUE
    if ((10 * getHR(professor)) + getPAP(professor)) >= (parameter["PERCEN"][professor[F_PROFILE_REGIME]] * ((10 * parameter["HD"][professor[F_PROFILE_REGIME]]) + parameter["PAP"][professor[F_PROFILE_REGIME]])):
       return F_RETURN_TRUE
    if ((10 * getHR(professor)) + getPAC(professor)) >= (parameter["PERCEN"][professor[F_PROFILE_REGIME]] * ((10 * parameter["HD"][professor[F_PROFILE_REGIME]]) + parameter["PAC"][professor[F_PROFILE_REGIME]])):
       return F_RETURN_TRUE
    return F_RETURN_FALSE

def analyzeArticle07 (professor):
    if (getHR(professor) < parameter["HD"][professor[F_PROFILE_REGIME]]):
       return F_RETURN_FALSE
    return F_RETURN_TRUE

def analyzeArticle08 (professor):
    if (getQUALIF(professor) < parameter["QUALIF"][professor[F_PROFILE_REGIME]]):
       return F_RETURN_FALSE
    return F_RETURN_TRUE

def analyzeArticle09 (professor):
    meses =  getAFAST(professor)
    meses += getSum(professor, "IV-1-1;IV-1-2")/14
    meses += getSum(professor, "IV-1-3;IV-1-4")/12
    meses += getSum(professor, "IV-1-5;IV-1-6;IV-1-7;IV-1-8;IV-1-9")/10
    meses += getSum(professor, "IV-1-10;IV-1-11;IV-1-12;IV-1-13;IV-1-14;IV-1-15")/8
    if (6 > meses):
       return F_RETURN_FALSE
    return F_RETURN_TRUE

def writeAnalysisFile(file, professor):
    for item in professor:
        if (item[0] not in ["I","V"]):
           file.write(item[0].upper() + item[1:] + ": " + str(professor[item]) + "\n")
    file.write("\n")
    for x in activity:
       file.write("%6s %-47s %6.2f\n" % (x, activity[x], professor[x]))
    file.write("\nParâmetros (valores mínimos)\n")
    for x in parameter:
       file.write("%6s: 20h = %6.2f , 40h = %6.2f\n" % (x, parameter[x]["20h"], parameter[x]["40h"]))
    file.write("\nValores calculados para o docente")
    file.write ("\nMédia de horas aulas (HR):                        %6.2f" % getHR(professor))
    file.write ("\nPontuação acadêmica do docente (PAE):             %6.2f" % getPAE(professor))
    file.write ("\nPontuação de atividades coletivas (PAC):          %6.2f" % getPAC(professor))
    file.write ("\nPontuação de atividades de produção (PAP):        %6.2f" % getPAP(professor))
    file.write ("\nPontuação de atividades de qualificação (QUALIF): %6.2f" % getQUALIF(professor))
    file.write ("\n\nAvaliação conforme a Resolução CD/INF 30/2018")
    file.write ("\nAtendimento ao Artigo 06: " + analyzeArticle06 (professor))
    file.write ("\nAtendimento ao Artigo 07: " + analyzeArticle07 (professor))
    file.write ("\nAtendimento ao Artigo 08: " + analyzeArticle08 (professor))
    file.write ("\nAtendimento ao Artigo 09: " + analyzeArticle09 (professor))

# main program
if not os.path.exists("./" + F_ANALYSIS_DIR):
    os.makedirs("./" + F_ANALYSIS_DIR)
# professor dictionary
professor = {}
# for each professor (jason file)
for fileName in getFile( "*.json", "./" + F_DATABASE_DIR):
    jsonFile = open(fileName)
    professor = {}
    professor = json.load(jsonFile)
    print ("Evaluating ... " + professor[F_PROFILE_NOME])
    analysisFile = open("./" + F_ANALYSIS_DIR + "/" + professor[F_PROFILE_NOME] + ".txt", "w")
    writeAnalysisFile(analysisFile, professor)
    analysisFile.close()
print ("Fim de processamento ... favor os arquivos no diretório '" + F_ANALYSIS_DIR + "'")