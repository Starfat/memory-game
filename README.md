# memory-game
OBJ2000 - Obligtorisk oppgave 2020 - Memory Game

Koden skal ha en klasse som er entry point, som ikke ligger i noen bestemt pakke, og som du kan kalle hva du vil.

Pakken "gui" skal ha tre klasser som er deklarert med ordet public.

Disse tre klassene skal ha følgende navn og innhold:

MemoryGameWindow
- Skal spesialisere JFrame og implementere ActionListener.
- Skal også inneholde den indre klassen GameMenubar som spesialiserer JMenuBar.
- Skal ha ansvar for å utføre de tre menyvalgene som forberedes i GamePanel.

GamePanel
- Skal spesialisere JPanel.
- Skal også inneholde den indre klassen TheMouseListener som spesialiserer MouseAdapter.
- Skal finne på en farge til hver instans av ColoredPanel og levere den til instansen
- Skal ha ansvar for å reagere når spilleren klikker på en farge.
- En instans av TheMouseListener må overleveres til hver instans av ColoredPanel.

ColoredPanel
- Skal spesialisere JPanel.
- Skal huske sin tildelte farge
- Skal ha meldinger som kan sette bakgrunnen til nøytral (for eksempel lysegrå)
- Skal ha meldinger som kan sette bakgrunnen til den fargen den har fått tildelt.
- Skal kunne ta i mot en MouseListener og installere den.


Programdesign
Listen med fire klasser som du nå har lest gjennom, er et enkelt "programdesign". I denne oppgaven må du følge dette programdesignet nøyaktig.

Støtte i rammeverket
For å finne tilfeldige verdier, som for eksempel indekser i et array, kan du bruke klassen Random.
Hvis arrayet har for eksempel tre farger, vil du kunne instansiere klassen Random slik:
Random r = new Random();
Og deretter finne en tilfeldig verdi slik:
index = r.nextInt(3);

Eller hvis arrayet med farger heter colors, er denne løsningen enda bedre:

index = r.nextInt(colors.length);

Hvis GamePanel har fått meldingen add flere ganger slik at den inneholder flere komponenter, kan du finne antallet slik:
getComponentCount()

Du kan finne hver enkelt komponent slik:
getComponent(x)

Du kan type-konvertere hver komponent slik:
(ColoredPanel) getComponent(i)
