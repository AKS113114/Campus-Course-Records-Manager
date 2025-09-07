📘 Campus Course & Records Manager (CCRM)

A Java SE console-based application to manage students, courses, enrollment, grading, and file operations. This project was developed as part of the Programming in Java flipped course at VIT Bhopal.

🚀 Features

Student Management → Add, update, list, deactivate students.

Course Management → Add, update, search courses, assign instructors.

Enrollment → Enroll/unenroll students with credit rules.

Grading → Record marks, assign letter grades, compute GPA.

File Utilities → Import/export CSVs, backup folders, recursive utilities.

Reports → Print transcripts, filter courses/students with Streams API.

📂 Project Structure
Campus-Course-Records-Manager/
 ├─ src/              # Java source code
 │   └─ edu/ccrm/...  # domain, service, cli packages
 ├─ screenshots/      # UI and output screenshots
 ├─ recordings/       # optional demo recordings
 ├─ testdata/         # sample CSV input/output files
 ├─ README.md         # project documentation
 └─ .gitignore

🛠️ Tech Stack

Language: Java SE 8+

IDE: Eclipse / IntelliJ / VS Code

Libraries: Java Collections, Streams, NIO.2, Date & Time API

📖 Documentation (Required Sections)
1. Evolution of Java

Java 1995 (initial release by Sun Microsystems) → Java 8 (2014, Streams & Lambdas) → Java 17 (LTS).

From applets → enterprise → cloud-native development.

2. Java ME vs SE vs EE

Java ME: Mobile & embedded devices.

Java SE: Core Java, standard applications (this project uses SE).

Java EE: Enterprise apps, web servers, distributed systems.

3. Java Architecture

JDK → Tools + JRE.

JRE → Libraries + JVM.

JVM → Runs bytecode across platforms (WORA).

4. Installation Guide

Install JDK (Oracle/OpenJDK).

Add JAVA_HOME and update PATH.

Verify with:

java -version
javac -version

5. Eclipse Setup

Download Eclipse IDE for Java Developers.

Create new Java project → link to this repo.

Add packages under edu.ccrm.*.

Run Main.java.

(Add screenshots of setup in /screenshots)

▶️ How to Run
cd src
javac Main.java
java Main

📸 Screenshots & Recordings

Place program run screenshots in /screenshots.

Place demo recordings (optional) in /recordings.

📊 Evaluation Readiness

✅ Repository public (or VITYARTHI invited as collaborator).
✅ README includes all required documentation.
✅ Code structured with OOP, enums, exceptions, Streams, etc.
✅ Plagiarism & AI-generated content avoided.

👨‍💻 Author

Aman Kumar Singh
B.Tech CSE (Gaming Technology) – VIT Bhopal
