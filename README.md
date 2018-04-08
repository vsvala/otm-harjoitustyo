
# <h1>Ohjelmoinnin-harjoitustyö: FitMe sovellus
Ohjelmoinnin harjoitustyönä tehty Fitme sovellusprojekti sekä projektin dokumentaatio ja testaus.

## <h2>Dokumentaatio

[Käyttöohje](https://github.com/vsvala/otm-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/vsvala/otm-harjoitustyo/blob/master/dokumentaatio/vaatimusm%C3%A4%C3%A4rittely.md)

[Arkkitehtuurikuvaus](https://github.com/vsvala/otm-harjoitustyo/blob/master/dokumentaatio/arkkitehtuurikuvaus)

[Testausdokumentti](https://github.com/vsvala/otm-harjoitustyo/blob/master/dokumentaatio/testaus.md)

[Työaikakirjanpito](https://github.com/vsvala/otm-harjoitustyo/blob/master/dokumentaatio/ty%C3%B6aikakirjanpito)


## <h2>Komentorivitoiminnot

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Fitme-1.0-SNAPSHOT.jar_

### JavaDoc

JavaDoc generoidaan komennolla

```
mvn javadoc:javadoc
```

JavaDocia voi tarkastella avaamalla selaimella tiedosto _target/site/apidocs/index.html_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/mluukkai/FitMe/blob/master/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
