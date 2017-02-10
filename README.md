# Base Contacts

Point de départ d'un exercice autour de la découverte de JDBC sans prise en compte des problématiques de gestion d'exception.
La base cible est une base Oracle XE dont le script de création des tables est fourni. Il est donc supposé au préalable que cette base soit créée et disponible.

Chaque étape est traitée dans une branche de son nom, l'ensemble des étapes à suivre est définie ci-dessous :
- 1. Initier un projet contenant une unique classe, en partant de l'exemple du projet [BaseRH](https://github.com/simplon-promo-pe-1/baserh) qui vous a été fourni, tout en appliquant les meilleures pratiques dont vous pouvez à ce jour avoir connaissance
- 2. Modifier la classe principale afin de lister dans la console les prénoms de tous les contacts (triés)
- 3. Observer les imports en *java.sql.\** et aller consulter la (Java)Doc en ligne pour découvrir les premiers éléments de l'**API JDBC**
- 4. (optionnel) Adapter votre code pour réaliser la même requête sur une base MySQL
- 5. Sortir user/mot de passe de la chaîne de connexion et les fournir au moment de la création de la connexion
- 6. Adapter le code pour exécuter une requête permettant de lister l'ensemble des emails des contacts de type 'friend'
- 7. Utiliser la variante de la méthode *getString* de l'interface **ResultSet** pour récupérer le contenu de la colonne sans la nommer
- 8. Adapter votre code pour exploiter le 1er argument de votre programme afin de l'utiliser à la place de la restriction "en dur" limitant les contacts aux 'friend'. Votre programme devra donc désormais prendre en argument d'exécution la valeur *friend* (ou toute autre valeur visant à restreindre la liste des emails selon le type de contact)
- 9. Se documenter sur *PreparedStatement* et améliorer le code
- 10. Se documenter sur le Design Pattern **DAO** et mettre en place une interface **ContactsDAO** et son implémentation **JdbcContactsDAO** qui seront utilisé dans votre classe de type Main. La méthode à faire figurer dans l'interface est la suivante : *public List<String> findEmailsByContactType(String type) throws Exception;*
