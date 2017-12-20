#Failisüsteemi paigutus mälus - operatsioonisüsteemide kodutöö 4

###Kirjeldus
Failisüsteemi ühetasemelise indekseeritud paigutuse visualeering.

###Kasutus
OpSysKodu4.jar

###Java version
1.8

###Kasutatud moodulid
JavaFX

###Autor
Tambet-Telvis Tanilsoo

###Küsimus
* Kui suur protsent allesjäänud failidest on fragmenteerunund (koosnevad rohkem kui ühest fragmendist)?
* Kui suur protsent kasutatud ruumist kuulub fragmenteerunud failidele?

Kummal viisil mõõdetud fragmenteeritus on pöörleva ketta jõudluskao iseloomustamiseks mõistlikum (põhjenda)?
Esimene(fragmenteerunud failide osa kogu failidest), sest annab täpsema info, kui suurel osal failidest ketasel on jõukadu. Teise puhul võib tekkida situatsioon, kus ühe või väheste fragmenteeritud failide suurus võtab enamik osa mälust, kuigi mitte-fragmenteerunud failide arv on suurem ning tulemuses näib, et jõukadu on suurem. 