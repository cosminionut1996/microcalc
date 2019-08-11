# microcalc
calculator working with microservices


Toate microserviciile ruleaza pe portul 80.
Toate microserviciile accepta doi parametri intregi, x si y prin metoda post.
Toate microserviciile returneaza rezultatul calculului ca numar intreg.
Microserviciile pastreaza in baza de date istoricul calculelor efectuate.

Din front-end:
  se pot crea request-uri pentru calcule + afisarea rezultatului.
  se poate vedea istoricul calculelor.

Un server proxy nginx se va folosi pentru a face rutarea intre front-end si microservicii.
  *Optional un alt server proxy nginx se poate folosi pentru a filtra request-urile catre front-end.

Se foloseste PostgreSQL pentru baza de date.
