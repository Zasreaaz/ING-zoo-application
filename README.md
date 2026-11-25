# ING-zoo-application
Testopdracht voor stage bij ING: een Java-consoleapplicatie van een dierentuin.

De originele opdracht staat in [`zoo-ing-initial/README.md`](zoo-ing-initial/README.md).

---
## Starten
- **JDK:** 1.8 of hoger
- Open `zoo-ing-initial` in IntelliJ IDEA en run `com.ing.zoo.Zoo`
- Of via de terminal:
  ```bash
  cd zoo-ing-initial/src
  javac -d ../out $(find . -name "*.java")
  java -cp ../out com.ing.zoo.Zoo
  ```

---
## Commands
| Command | Resultaat |
|---|---|
| `hello` | Alle dieren zeggen hallo |
| `hello <naam>` | Alleen dat dier zegt hallo, bijv. `hello henk` |
| `give leaves` | Alle herbivores krijgen bladeren |
| `give meat` | Alle carnivores krijgen vlees |
| `perform trick` | Alle dieren die een trucje kunnen, doen hun trucje |
| `exit` | Stopt de applicatie |

### Extra commands
| Command | Resultaat |
|---|---|
| `hello <soort>` | Alle dieren van die soort zeggen hallo, bijv. `hello zebra` |
| `give leaves <naam of soort>` | Alleen dat dier krijgt bladeren; een carnivore weigert |
| `give meat <naam of soort>` | Alleen dat dier krijgt vlees; een herbivore weigert |

Voorbeeld:
```
Voer uw command in: give meat zebra
marty: meat? Sorry, I'm a herbivore, I don't eat meat!
```

---
## Dieren
| Naam | Soort | Eet | Trucje |
|---|---|---|---|
| henk | Lion | vlees | nee |
| wally | Tiger | vlees | ja |
| akela | Wolf *(nieuw)* | vlees | nee |
| elsa | Hippo | bladeren | nee |
| marty | Zebra | bladeren | nee |
| george | Monkey *(nieuw)* | bladeren | ja |
| dora | Pig | vlees en bladeren | ja |

---
## Wat ik heb gedaan

### Class-structuur
- **`Animal`** (abstract): bevat de naam en `sayHello()`. Elk dier geeft alleen zijn eigen hello-tekst.
- **Interfaces** voor gedrag:
  - `Herbivore` → `eatLeaves()`
  - `Carnivore` → `eatMeat()`
  - `TrickPerformer` → `performTrick()`
- Elk dier implementeert alleen wat het kan. Daardoor kan `eatMeat()` niet aangeroepen worden op een `Zebra`: dat geeft al een compile-fout.
- Velden zijn `private` in plaats van `public`.
- Gekozen voor interfaces in plaats van subclasses (`Herbivore extends Animal`), omdat Java geen meervoudige overerving heeft. Een `Pig` is zowel herbivore als carnivore, en kan met interfaces allebei implementeren.

### Mappenstructuur
```
src/com/ing/zoo/
├── Zoo.java                  # main + afhandeling van commands
├── animals/
│   ├── Animal.java
│   ├── herbivores/           # Hippo, Monkey, Zebra
│   ├── carnivores/           # Lion, Tiger, Wolf
│   └── omnivores/            # Pig
└── behaviours/               # Herbivore, Carnivore, TrickPerformer
```

### Eisen
- [x] Applicatie afgemaakt: alle commands werken
- [x] Folder structuur gereorganiseerd
- [x] Code gerefactord
- [x] 2 nieuwe dieren toegevoegd: `Monkey` en `Wolf`
- [x] Bij elke command wordt het resultaat in de console getoond

### Extra
- `hello`, `give leaves` en `give meat` werken op naam en op soort
- Een dier weigert eten dat het niet lust, met een melding
- De applicatie blijft commands vragen tot je `exit` typt (origineel stopte na één command)
- Hoofdletters en extra spaties in de input maken niet uit
- Melding bij een onbekend command of een onbekende naam
- Elke regel output begint met de naam van het dier, zodat je ziet wie wat zegt
- `Pig` zei "splash" (copy-paste van `Hippo`), aangepast naar "oink oink"
