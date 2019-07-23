Piszemy aplikację do manipulowania zadaniami. 
Użytkownik może podjąć decyzję co chciałby zrobić. Może np.:
- listować zadania (get)
- dodawać zadania  (put)
- usuwać zadania (delete)
- edytować zadania (post)
Pod wpływem wpisania co chciałby zrobić, powinniśmy:
 - wylistować mu listę zadań
 - pozwolić mu dodać zadanie (użytkownik wpisuje name, oraz wypełnia pole done)
 - usunąć odpowiednie zadanie (użytkownik podaje id lub nazwę [i wtedy my musimy znaleźć identyfikator po nazwie])
 - edytować (użytkownik może wpisać nową nazwę zadania albo oznaczyć je jako zrobione)
 
dodatkowo:
użytkownik może zaptyać : 
- wypisz_wykonane
- wypisz_niewykonane
- oznacz_jako_wykonane 34 
(ostatnia komenda zmienia status done zadania 34 na true.)
- oznacz_jako_niewykonane 34
(ostatnia komenda zmienia status done zadania 34 na false.)
