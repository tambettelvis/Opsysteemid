#Failis�steemi paigutus m�lus - operatsioonis�steemide kodut�� 4

###Kirjeldus
Failis�steemi �hetasemelise indekseeritud paigutuse visualeering.

###Kasutus
OpSysKodu4.jar

###Java version
1.8

###Kasutatud moodulid
JavaFX

###Autor
Tambet-Telvis Tanilsoo

###K�simus
* Kui suur protsent allesj��nud failidest on fragmenteerunund (koosnevad rohkem kui �hest fragmendist)?
* Kui suur protsent kasutatud ruumist kuulub fragmenteerunud failidele?

Kummal viisil m��detud fragmenteeritus on p��rleva ketta j�udluskao iseloomustamiseks m�istlikum (p�hjenda)?
Esimene(fragmenteerunud failide osa kogu failidest), sest annab t�psema info, kui suurel osal failidest ketasel on j�ukadu. Teise puhul v�ib tekkida situatsioon, kus �he v�i v�heste fragmenteeritud failide suurus v�tab enamik osa m�lust, kuigi mitte-fragmenteerunud failide arv on suurem ning tulemuses n�ib, et j�ukadu on suurem. 