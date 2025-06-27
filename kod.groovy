int nem1 = A0;     // 1. nem sensörü (bitki 1)
int nem2 = A1;     // 2. nem sensörü (bitki 2)
int role1 = 7;     // 1. pompa bağlı role pini
int role2 = 8;     // 2. pompa bağlı role pini

int sinirDeger = 150;  // Nem eşiği (0-1023 arasında), kuru için 600 önerilir

void setup() {
  pinMode(role1, OUTPUT);
  pinMode(role2, OUTPUT);
  digitalWrite(role1, HIGH); // Başlangıçta pompaları kapat
  digitalWrite(role2, HIGH);
  Serial.begin(9600);       // Seri monitör için
}

void loop() {
  int deger1 = analogRead(nem1);
  int deger2 = analogRead(nem2);

  Serial.print("Nem 1: "); Serial.print(deger1);
  Serial.print(" | Nem 2: "); Serial.println(deger2);

  // 1. Bitki için kontrol
  if (deger1 < sinirDeger) {
    digitalWrite(role1, LOW);   // Pompa 1 çalışsın
    delay(1000);                 // 1 saniye su ver
    digitalWrite(role1, HIGH);    // Pompa 1 kapansın
  }

  // 2. Bitki için kontrol
  if (deger2 < sinirDeger) {
    digitalWrite(role2, LOW);   // Pompa 2 çalışsın
    delay(1000);                 // 1 saniye su ver
    digitalWrite(role2, HIGH);    // Pompa 2 kapansın
  }

  delay(10000); // Her 10 saniyede bir kontrol et
}
