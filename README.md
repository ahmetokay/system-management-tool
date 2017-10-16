# system-management-tool

Istek icerigi

	- URL
		- GET
		- DELETE
			URL Parametreleri kullanilacak

		- POST
		- PUT
			Istegin icerigi kullanilacak

********************************************************************************************************************************************************************************************************************	

Hata durumlari

		Sunucu pinge kapali olabilir
		ping(ipAddress){

			Server kapanmis olabilir.[Server'a ulasilamama sebebi bulunabilecek mi?]
			Baglanti mi yok?
			Makina mi kapali?
			...

			onSucces(){
				// Happy path
			}

			onFail(){
				Makinaya ulasilamiyor...
			}
		
		}

		telnet(ipAddress, port){

			Uygulama kapanmis olabilir. -> Kullanicidan script alinacak.[IP, username ve password gerekli olacak]
			Port kontrolu yeterli mi?

			onSucces(){
				// Happy path
			}

			onFail(){
				// Uygulama ayakta degildir.
			}

		}

		request(){

			HTTP hatalari
				Mail atilmasi yeterli mi?

			Custom hatalar
				Gelen cevabin icerigi mail olarak atilmali mi? [Sorun maile atilacak icerik buyuk olursa ne olacak?(Belli bir arakter araligi 400 mesela yeterli olacak mi?)]

			HTTP client'in yaptigi istek sonucunda donen stream incelenmeli..........[Header uzerinde gelen status alinip geri kalan birakilmali.]

			onSucces(){
				// Happy path
			}

			onFail(){

			}

		}





********************************************************************************************************************************************************************************************************************


	- Notification islemi icin mail ve sms beraber olmali. Tabloya sms bilgileri eklenmeli.

	- Alinan zamani cron cevirme isi