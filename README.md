⚽ Java Football League Manager
This is a console-based Java application that simulates a full football league. It allows users to:

Set the number of teams

Input team names

Generate fixtures (home and away)

Enter scores

View league standings based on points and goal difference

🎯 Features
✅ Minimum 2 teams

✅ Fixture generation (round-robin format)

✅ Manual score input

✅ Calculates points & goal differences

✅ Displays a ranked league table

🛠 Technologies
Java (JDK 8+)

Console Input/Output

No external libraries

🚀 How to Use
When you run the program, you'll see the following menu:

java
Kopyala
Düzenle
1-Takim Sayisi Belirleyin (min 2)
2-Takim Isimlerini Girin
3-Fikstur Olusturun
4-Skor girme
5-Puan Durumu Goruntuleme
6-Cikis
You can select operations step by step.

📸 Sample Workflow & Output
1️⃣ Set Team Count
arduino
Kopyala
Düzenle
Takim Sayisini Belirleyin (min 2):
> 4
Takim Sayisi: 4 olarak belirlenmistir.
2️⃣ Enter Team Names
yaml
Kopyala
Düzenle
Takim isimlerini girin:
Takim 1: Galatasaray
Takim 2: Fenerbahçe
Takim 3: Beşiktaş
Takim 4: Trabzonspor
Takimlerin isimleri basarili olarak kaydedilmistir
3️⃣ Generate Fixture
yaml
Kopyala
Düzenle
Birinci Yari:
Hafta 1: Galatasaray VS Trabzonspor ||| Fenerbahçe VS Beşiktaş
Hafta 2: Galatasaray VS Beşiktaş ||| Trabzonspor VS Fenerbahçe
Hafta 3: Galatasaray VS Fenerbahçe ||| Beşiktaş VS Trabzonspor

Ikinci Yari:
Hafta 1: Trabzonspor VS Galatasaray ||| Beşiktaş VS Fenerbahçe
Hafta 2: Beşiktaş VS Galatasaray ||| Fenerbahçe VS Trabzonspor
Hafta 3: Fenerbahçe VS Galatasaray ||| Trabzonspor VS Beşiktaş
4️⃣ Enter Scores
yaml
Kopyala
Düzenle
Galatasaray vs Trabzonspor
Skor Takim 1: 2
Skor Takim 2: 1
Galatasaray Kazandi

Fenerbahçe vs Beşiktaş
Skor Takim 1: 1
Skor Takim 2: 1
Berabere

...

Takimlarin Skorlari:
Galatasaray 2 - 1 Trabzonspor
Fenerbahçe 1 - 1 Beşiktaş
...
5️⃣ View Standings
yaml
Kopyala
Düzenle
Puan Durumu:
Takim           Puan       Averaj    
Galatasaray     15         +10       
Fenerbahçe      11         +4        
Beşiktaş        9          +1        
Trabzonspor     5          -6
📂 Project Structure
bash
Kopyala
Düzenle
/src
 └── com/mycompany/futbolligi
     └── FutbolLigi.java
README.md
🧠 Logic Summary
Round-robin fixture algorithm

Matrix (int[][] skorlar) to store match results

Points: Win = 3, Draw = 1, Loss = 0

League table is sorted by points, then goal difference

📄 License
This project is open-source. Free to use and modify for learning or academic purposes.
