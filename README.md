# Generateur de password

Dans un projet Maven implémentez les classes **RandomPassword**, **InitializationException** et **BadPasswordException** tel que

groupId = org.heg<br>
artifactId = random-password-generator<br>
version = 1.0.0-SNAPSHOT<br>

- La classe RandomPassword implémente l'interface IRandomPassword fournie
- La classe RandomPassword limite la longueur minimale et la longueur maximale du password. Dans tous les cas on ne génère jamais de mot de passe < MIN_LENGTH et > MAX_LENGTH (valueurs figurant dans l'interface)
- La classe RandomPassword peut générer des passwords avec des chiffres et/ou des lettres et/ou des majuscules
- La classe InitializationException est levée si on essaie d'initialiser la classe RandomPassword avec des limites interdites
- La classe BadPasswordException est levée si on essaie de generer un password qui ne respecte pas les contraintes

- Créer une classe de test avec une méthode main() afin de tester votre code
- Générer un mot de passe de longueur 8 avec des lettres, des chiffres et des majuscules
- Générer un mot de passe de longueur 10 avec des lettres, des chiffres uniquement
- Générer un mot de passe de longueur 20 avec des majuscules uniquement
<br>
A l'aide de Maven mettre à disposition ce generateur de password dans le local repository en version 1.0.0-SNAPSHOT
<br>
<br>
Créez un deuxième projet Maven, ajoutez la lib random-password-generator dans les dependencies. Dans une classe Main utilisez le generateur de password et vérifiez son bon fonctionnement.
