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


