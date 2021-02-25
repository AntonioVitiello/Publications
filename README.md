### Creare un applicazione Android che simuli il comportamento di una edicola, andando a mostrare i numeri di una rivista digitale.

I numeri devono essere mostrati con una lista riportando per ciascuno: 
- Cover 
- Titolo 
- Pulsante di download/acquista 

## Lista APIs:
- Recupero publications: 
https://api-ne.paperlit.com/v8/projects/prj_5df8a84c8ef9a/publications 
- Recupero numeri: 
https://api-ne.paperlit.com/v8/projects/prj_5df8a84c8ef9a/issues/{$publicationId?} 

## Bearer token:
- Per l’accesso è necessario utilizzare un header di autenticazione 

eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwcm9qZWN0SWQiOiJwcmpfNWRmOGE4NGM4Z
WY5YSIsInByb2plY3RQZXJtaXNzaW9uc0JpdG1hc2siOjF9.xNsGH_q3anUNhn64RZ-HX8chuqr5
UkOuAFfUndleHK0 

## Numero gratuito o a pagamento:
La label “Download” o “Acquista” del pulsante del singolo numero deve recuperare lo stato 
“isForSale” fornito in API (True = Acquista, False = Download). Non è richiesto che l’acquisto 
o il download funzionino realmente. 

## Download immagine di copertina: 
Per la copertina del numero occorre recuperare l’url della chiave “imagesUrl” e sostituire la 
maschera {0:000} con il valore 001.

![Home section - Issue](https://github.com/AntonioVitiello/Publications/blob/master/art/screen1.png)
![Home section - Download](https://github.com/AntonioVitiello/Publications/blob/master/art/screen2.png)
![Home section - Acquista](https://github.com/AntonioVitiello/Publications/blob/master/art/screen3.png)
