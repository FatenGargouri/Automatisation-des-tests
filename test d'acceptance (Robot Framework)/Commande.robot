*** Settings ***
Documentation    Tester Add to Chart
Library           SeleniumLibrary


*** Variables ***
${URL}      https://dineshvelhal.github.io/testautomation-playground/login.html
${BROWSER}            Chrome


*** Test Cases ***
Processus de commande
    Ouvrir la page login 
    Maximize Browser Window
    Remplir le forumaire d'authentification (login :admin,password : admin)
    Cliquer sur le bouton Login
    Passer une commande (Select Medium , Cheese, Marinara , Green olive, set quantity 3) 
    Cliquer sur le bouton Add to the cart 
    Vérifier le message de réussite  

*** Keywords ***
Ouvrir la page login
    Open Browser    ${URL}    ${BROWSER}

Remplir le forumaire d'authentification (login :admin,password : admin)
    Input Text   id:user   admin
    Sleep    1s
    Input Text   id:password  admin
    Sleep    1s
Cliquer sur le bouton Login    
    Click Button    id:login
    Title Should Be    Order Pizza

Passer une commande (Select Medium , Cheese, Marinara , Green olive, set quantity 3) 
    Click Element    id:rad_medium
    Sleep    1s
    Select From List by Value     id:select_flavor  Cheese
    Sleep    1s
    Click Element    id:rad_marinara
    Sleep    1s
    Select Checkbox    id:green_olive
    Sleep    1s
    Input Text    id:quantity    3
    Sleep    1s
Cliquer sur le bouton Add to the cart     
    Click Button    name:submit_button
    Sleep    3s
    
Vérifier le message de réussite  
    Wait Until Element Is Visible    id=added_message
    Element Text Should Be    id=added_message      Pizza added to the cart!














