# 📰 Sports Newsroom Management

## 📄 Description - Exercise Statement

### Exercise 1

In a sports newsroom, news articles are categorized by sports: football, basketball, tennis, F1, and motorcycling.

The newsroom may have more than one journalist. For each journalist, we need to know their **name**, **ID (DNI)**, and **salary**. Once assigned, the DNI can never be changed. All journalists share the same salary, currently set at **€1500**, and any future increase would apply to all equally.

Each journalist can work on multiple news articles. Each article must have a **headline**, **text**, **score**, and **price**. Upon creation, the text must be empty.

Additional information is required depending on the type of news:

- **Football news**: competition (String), club (String), and player (String).
- **Basketball news**: competition (String), and club (String).
- **Tennis news**: competition (String), and players (String).
- **F1 news**: racing team (String).
- **Motorcycling news**: team (String).

### 💰 Price Calculation Method: `calcularPreuNoticia()`

**Football News:**
- Base price: €300
- Champions League: +€100
- Barça or Madrid: +€100
- Ferran Torres or Benzema: +€50

_Example_: A news article about Ferran Torres scoring for Barça in the Champions League would cost **€550**.

**Basketball News:**
- Base price: €250
- EuroLeague: +€75
- Barça or Madrid: +€75

**Tennis News:**
- Base price: €150
- Federer, Nadal, or Djokovic: +€100

**F1 News:**
- Base price: €100
- Ferrari or Mercedes: +€50

**Motorcycling News:**
- Base price: €100
- Honda or Yamaha: +€50

### ⭐ Score Calculation

**Football News:**
- Base score: 5
- Champions League: +3
- National League: +2
- Barça or Madrid: +1
- Ferran Torres or Benzema: +1

**Basketball News:**
- Base score: 4
- EuroLeague: +3
- ACB: +2
- Barça or Madrid: +1

**Tennis News:**
- Base score: 4
- Federer, Nadal, or Djokovic: +3

**F1 News:**
- Base score: 4
- Ferrari or Mercedes: +2

**Motorcycling News:**
- Base score: 3
- Honda or Yamaha: +3

### 🧾 Main Menu (Console App)

1. Add journalist
2. Remove journalist
3. Add news article to journalist
4. Remove news article (requires journalist and headline)
5. Display all articles by journalist
6. Calculate article score
7. Calculate article price

---

## 💻 Technologies Used

- Java (or your selected programming language)
- Object-Oriented Programming (OOP) principles
- Command-line interface (CLI)
- [Add other libraries or tools here, if applicable]

---

## 📋 Requirements

- Java JDK 11 or higher (or your relevant version)
- IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)
- Git (for version control)
- [Include additional dependencies here]

---

## 🛠️ Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/sports-newsroom.git
