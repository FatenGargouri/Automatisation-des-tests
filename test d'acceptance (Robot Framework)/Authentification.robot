*** Settings ***
Documentation    Tester authentification 
Library           SeleniumLibrary
Suite Teardown    Close All Browsers

*** Variables ***
${URL}      https://dineshvelhal.github.io/testautomation-playground/login.html
${BROWSER}            Chrome


*** Test Cases ***

Processus de création compte
    Ouvrir la page login 
    Maximize Browser Window
    Cliquer sur New User
    Remplir le formulaire de registre 
    Cliquer sur Register Now
    Vérifier le message de confirmation
   
Processus d'authentification
    Ouvrir la page login 
    Maximize Browser Window
    Remplir le forumaire d'authentification 
    Cliquer sur Login 
    vérifier l'affichage de formulaire de formulaire Pizza


*** Keywords ***
Ouvrir la page login
    Open Browser    ${URL}    ${BROWSER}
    Sleep    1s
Cliquer sur New User    
    Click Element    xpath=/html/body/div/form/div[4]/a
    Sleep    1s
Remplir le formulaire de registre
    Input Text   name:first_name    admin
    Sleep    1s
    Input Text   name:last_name    admin
    Sleep    1s
    Input Text   name:email    admin@gmail.com
    Sleep    1s
    Input Password   id:pwd1    admin
    Sleep    1s
    Input Password   id:pwd2    admin
    Sleep    1s
    Select Checkbox   name:terms
    Sleep    1s
Cliquer sur Register Now
    Click Button    xpath=//*[@id="submit_button"]
    Sleep    1s
Vérifier le message de confirmation    
    Title Should Be    Confirmation!

Remplir le forumaire d'authentification 
    Input Text   id:user   admin
    Sleep    1s
    Input Text   id:password  admin
Cliquer sur Login    
    Click Button    id:login
    Sleep    1s
vérifier l'affichage de formulaire de formulaire Pizza    
    Title Should Be    Order Pizza










