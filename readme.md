Dependency Injection Showcase – Java
Ce projet met en lumière différentes techniques d’injection de dépendances en Java, allant du couplage statique à l’utilisation avancée du framework Spring.

🧭 À propos du projet
L’objectif est de comparer plusieurs styles d’injection de dépendances à travers quatre approches principales :

Couplage statique (instanciation directe)

Instanciation dynamique (via la réflexion)

Configuration avec Spring (fichier XML)

Configuration avec Spring (annotations)

🗂️ Architecture du projet
lua
Copier le code
dependency-injection/
├── src/main/java/com/jee/
│   ├── static_instanciation/
│   ├── dynamic_instanciation/
│   ├── spring/
│   │   ├── xml/
│   │   └── annotations/
│   └── resources/
└── fichiers de config (config.xml, config.yaml, config.txt)
⚙️ Détails des Implémentations
1. 💡 Couplage Statique
   L’approche la plus simple, où les dépendances sont créées directement dans le code.

java
Copier le code
IDao dao = new IDaoImpl();
IMetier metier = new MetierImpl(dao);
System.out.println(metier.calcul());
📝 Remarque : Le couplage est fort, car les classes sont directement instanciées sans aucune abstraction.

2. 🧠 Instanciation Dynamique (Réflexion)
   Utilise des fichiers de configuration pour créer les objets dynamiquement à l’exécution.

Exemple config.yaml :
yaml
Copier le code
classes:
dao: "com.jee.dynamic_instanciation.dao.IDaoImpl"
metier: "com.jee.dynamic_instanciation.metier.MetierImpl"
Exemple config.txt :
Copier le code
com.jee.dynamic_instanciation.dao.IDaoImpl
com.jee.dynamic_instanciation.metier.MetierImpl
java
Copier le code
// Chargement des classes à partir du fichier YAML
Map<String, Object> yamlData = getYamlFileData();
...
Method method = metier.getClass().getDeclaredMethod("setDao", IDao.class);
method.invoke(metier, dao);
System.out.println(metier.calcul());
3. 🌱 Spring avec XML
   Injection de dépendances en utilisant un fichier config.xml.

Extrait :
xml
Copier le code
<bean id="dao" class="com.jee.spring.xml.extensions.DaoImplv2"/>
<bean id="metier" class="com.jee.spring.xml.metier.MetierImpl">
<constructor-arg ref="dao"/>
</bean>
java
Copier le code
ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
IMetier metier = context.getBean(IMetier.class);
System.out.println(metier.calcul());
4. 🧩 Spring avec Annotations
   Approche moderne utilisant les annotations pour déclarer les composants.

java
Copier le code
ApplicationContext context = new AnnotationConfigApplicationContext("com.jee.spring.annotations");
IMetier metier = context.getBean(IMetier.class);
System.out.println(metier.calcul());
📚 Dépendances
Spring Core 6.2.3

Spring Context 6.2.3

Spring Beans 6.2.3

Jakarta Annotation API 2.1.1

🚀 Exécution du projet
Cloner le dépôt

Compiler avec Maven :

bash
Copier le code
mvn clean install
Exécuter une des classes suivantes selon l’approche souhaitée :

Approche	Classe principale
Couplage statique	com.jee.static_instanciation.presentation.Presentation
Instanciation dynamique	com.jee.dynamic_instanciation.presentation.Presentation
Spring XML	com.jee.spring.xml.presentation.Presentation
Spring Annotations	com.jee.spring.annotations.presentation.Presentation