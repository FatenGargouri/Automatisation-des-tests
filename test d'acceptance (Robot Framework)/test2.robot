*** Settings ***
Library           SeleniumLibrary
Suite Teardown    Close All Browsers

*** Variables ***
${URL_VOITURES}       http://localhost:4200/voiture
${BROWSER}            Chrome
${client}   Remplir le formulaire
${Réservation}    Réservation
${CARD_TYPE}    Carte bancaire
${Numero_cart}    1111111111
${Facture}    Facture

*** Test Cases ***
Processus de Réservation
    Ouvrir la page de voiture    ${URL_VOITURES}    ${BROWSER}
    Cliquer sur Réserver
    Remplir le Formulaire de client
    Remplir le Formulaire de Réservation
    Remplir le Formulaire de Paiement
    Attendre Affichage de la Facture

*** Keywords ***
Ouvrir la page de voiture
    [Arguments]    ${url}    ${browser}
    Open Browser    ${url}    ${browser}

Cliquer sur Réserver
    Click Element   xpath=/html/body/app-root/app-voiture/html/body/div/div/div[1]/div/a

Remplir le Formulaire de client
    Wait Until Element Is Visible    xpath=/html/body/app-root/app-client/div/h1
    Input Text    id:nom    John Doe
    Input Text    id:email    john.doe@example.com
    Input Text    id:adresse   America
    Input Text    id:tel    11111111111111111111
    Click Button    id:submitButton

Remplir le Formulaire de Réservation
    Wait Until Element Is Visible    xpath=/html/body/app-root/app-reservation/div/h1
    Input Text     id:date_debut     2024-01-18T16:54:26.000Z	
    Input Text     id:date_fin        2024-01-18T16:54:26.000Z	
    Click Button    id:submitButton

Remplir le Formulaire de Paiement
    Wait Until Element Is Visible    xpath=/html/body/app-root/app-paiement/div/h1
    Select From List by Label    id:type_carte    ${CARD_TYPE}
    Input Text    id:numero_carte    ${Numero_cart}
    Click Button    id:submitButton


Attendre Affichage de la Facture
    Wait Until Element Is Visible    xpath=/html/body/app-root/app-facture/div/div[1]/h1
    Log    Facture Affichée avec Succès
