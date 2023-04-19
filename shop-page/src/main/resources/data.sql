INSERT INTO role VALUES
(1, 'ADMIN'),
(2, 'USER');

INSERT INTO users VALUES
(1, 1, 'admin@admin.pl', 'Admin', 'Admin', '$2a$10$iLpYZ2Xt9yNMXdQgJMI98OxkxUgmL2awfQjxwPNkLLed/7xeeRDFm'), --pass: 12345
(2, 1, 'user@user.pl', 'User', 'User', '$2a$10$iLpYZ2Xt9yNMXdQgJMI98OxkxUgmL2awfQjxwPNkLLed/7xeeRDFm'), --pass: 12345
(3, 1, 'user2@user.pl', 'User2', 'User2', '$2a$10$iLpYZ2Xt9yNMXdQgJMI98OxkxUgmL2awfQjxwPNkLLed/7xeeRDFm'); --pass: 12345

INSERT INTO user_role VALUES
(1, 1),
(2, 2),
(3, 2);

INSERT INTO product_type (name) VALUES
('LODÓWKI'),
('PRALKI'),
('ZMYWARKI'),
('ZAMRAŻARKI'),
('SUSZARKI'),
('OKAPY'),
('KUCHENKI'),
('AKCESORIA');

INSERT INTO product_count (product_count_id, available_amount, people_bought, item_bought) VALUES
(1, 20, 10, 15),
(2, 10, 2, 2),
(3, 99, 3, 4),
(4, 15, 5, 6),
(5, 2, 1, 5),
(6, 5, 2, 3),
(7, 55, 4, 4),
(8, 43, 9, 9),
(9, 21, 20, 21),
(10, 25, 10, 12),
(11, 24, 11, 11),
(12, 89, 30, 41),
(13, 72, 22, 62),
(14, 10, 2, 5),
(15, 3, 98, 105),
(16, 55, 2, 2),
(17, 41, 1, 1),
(18, 2, 10, 12),
(19, 10, 23, 26),
(20, 9, 7, 10),
(21, 10, 45, 65);

INSERT INTO product (producer, model, description, prize, product_type_id, product_count_id) VALUES
('MPM', '147-KB-12', 'Chłodziarko-zamrażarka klasy A+ z systemem automatycznego odszraniania, charakteryzująca się przemyślanym designem i wygodnym rozkładem półek.',
 879.00, 1, 1),
('SAMSUNG', 'RF56M9540SR/EF Family Hub', 'Przestronna i wygodna w użytkowaniu lodówka Samsung z linii MultiDoor doskonale wkomponuje się w kuchenne wnętrze, nadając mu wyrazisty charakter. Wykonane ze stali nierdzewnej urządzenie to nie tylko minimalistyczne i eleganckie wykończenie. To również m.in szereg funkcjonalnych rozwiązań takich jak: zewnętrzny dystrybutor wody czy szeroko otwierane drzwi, które ułatwiają dostęp do przechowywanych produktów.',
 14999.00, 1, 2),
('BOSCH', 'KAD 90VI20', 'Jedyna taka lodówka na rynku. Oświetlenie LED pozwala na zobaczenie zawartości swojej chłodziarki w nowym świetle.',
 4899.00, 1, 3),
('INDESIT', 'LR8 S2 X B', 'Indesit LR8 S2 X B jest lodówką na każdą kieszeń. Nie ma tu elektronicznego sterowania z wyświetlaczem, komory świeżości, czy innych “bajerów”. Jest po prostu dobra, pojemna lodówka – 228 litrów w chłodziarce i 111 w zamrażarce. Jej klasa energetyczna to A++, czyli eksploatacja również jest tania.',
 1199.00, 1, 4),
('LG', 'FH4U1JBS2', 'Flagowa pralka LG to ogromny wsad 1-10 kg i 1400 obrotów na minutę. Sprzęt, który pomieści ubrania wieloosobowej rodziny. Design sprawia, że jest to jedna z najładniejszych pralek na rynku.',
 2899.00, 2, 5),
('AMICA', 'DAW6103LSB', 'Świetny stosunek ceny do parametrów. Pralka o ładowności 1-6 kg i 1000 obrotów na minutę. Dzięki głębokości zaledwie 40,5 cm powinna zmieścić się w prawie każdej łazience.',
 1098.00, 2, 6),
('ELECTROLUX', 'EW8F229SP PerfectCare', 'Charakteruzuje się świetną funkcjęą pary – odświeżanie prania. Załadunek 9 kg i 1200 obr/min to parametry idealne dla dużej rodziny. Electrolux EW8F229SP ma świetny system zarządzania czasem prania: Time Manager.',
 2191.00, 2, 7),
('BEKO', 'DFS05011W', 'Zmywarka Beko posiada pojemność na 10 kompletów naczyń, szerokość 44,8 cm oraz 5 programów zmywania. Do tego najwyższa klasa efektywności suszenia A, jak również klasa energetyczna A+. Model DFS05011W ma także do zaoferowania system Water Safe, który chroni przed wyciekiem wody i zalaniem pomieszczenia. Warto również wspomnieć o technologii Hot Air Drying, zwiększającej naturalną wentylację dzięki wydostającemu się dodatkowym kanałem gorącemu powietrzu.',
 949.00, 3, 8),
('ASKO', 'D 5434', 'Próbka klasycznego skandynawskiego wzornictwa ma minimalistyczne formy. Cała uwaga jest zredukowana do okrągłych paneli dotykowych, co do punktów kontaktu z maszyną. Tutaj wszystko jest proste: lewy okrąg do wybierania programów, prawy to zegar.',
 779.00, 3, 9),
('BEKO', 'DPY8506GXB1', 'Oferuje wsad 8 kg, wyświetlacz LCD, 16 programów do wyboru, a także funkcję opóźnionego startu. Klasa energetyczna to A+++. Suszarka do ubrań cechuje się blokadą przed dziećmi, drzwiami o szerokości 38 cm (zmieścimy większe rzeczy typu koc), poziomem hałasu 65 dB oraz bębnem, który obraca się w dwóch kierunkach (ubrania nie są pogniecione) i jest oświetlony.',
 2599.00, 5, 10),
('BOSCH', 'WTW85461PL', 'Bosch WTW85461PL to stabilna i wydajna suszarka kondensacyjna z systemem suszenia pompą cieplną. Charakteryzuje się załadunkiem 9 kg, klasą energetyczną A++ oraz czujnikiem wilgotności ubrań (samodzielnie dobierze czas suszenia). To świetne rozwiązanie dla dużej rodziny.',
 2145.00, 5, 11),
('ELECTROLUX', 'EW8H458BP PerfectCare', 'EW8H458BP PerfectCareod firmy Electrolux, to bardzo wydajny model suszarki do ubrań z zabezpieczeniem w postaci blokady w przypadku przedwczesnego otwarcia drzwi. Ponadto, wsad to 8 kg, po zakończonej pracy usłyszymy dźwięk, a także zostaniemy poinformowani o konieczności wyczyszczenia filtra.',
 2399.00, 5, 12),
('SAMSUNG', 'HB6247SX', 'Samsung HB6247SX to podstawowy, ale jednocześnie bardzo solidny okap do zabudowy. Pozwala na szybkie, ciche i skuteczne usuwanie pary wodnej, oparów, dymu i zapachów. Trzy opcje prędkości wentylacji pozwalają na szybkie oczyszczenie powietrza, a klasyczny design pasuje do wystroju nowoczesnej kuchni. Warto wspomnieć o łatwym do czyszczenia filtrze powietrza wykonanym z aluminium, który zatrzymuje zanieczyszczenia i pomaga utrzymać kuchnię w czystości. Aktywne filtry węglowe służą natomiast do oczyszczania powietrza, które jest wypuszczane z powrotem do pomieszczenia.',
 449.00, 6, 13),
('BOSCH', 'DWK06G660', 'to dobrze wykonany okap kominowy cechujący się wydajnością maksymalną na poziomie 660 m3/h. Wyposażono go w funkcję intensywnego wentylowania, która po 10 minutach wraca do trybu normalnego. Oświetlenie halogenowe pozwala na odpowiednie oświetlenie płyty grzewczej. Urządzenie ma jeden silnik o mocy 250 W, który jest bardzo cichy. Poziom generowanego hałasu to zaledwie 53 dB.',
 1946.00, 6, 14),
('AMICA', 'IN. 900 BS', 'Amica IN. 900 BS to okap pięknie wykończony (ramka inox wokół szyby) i wyposażony w oświetlenie LED-owe. Można go zintegrować z płytą indukcyjną, dzięki czemu okap uruchomi się zawsze, gdy będziemy coś gotować. To drobna rzecz, ale może niesamowicie uprościć życie. Dzięki aluminiowemu filtrowi tłuszczowemu i 4-stopniowemu wentylatorowi, okap bez problemu poradzi sobie z usunięciem wszelkich nieczystości i zapachów. Jego maksymalna wydajność to 722 m3/h. Podobnie jak inne sprzęty z serii Amica IN., okap jest sterowany sensorowo.',
 1349.00, 6, 15),
('AMICA', 'EB8552 INTEGRA', 'Bardzo dobrze wykonany i na dodatek korzystnie wyceniony. W tym modelu znajdziesz 10 nastaw, a w tym grill i termoobieg. Piekarnik posiada funkcję rozmrażania, a czyści się parowo (wlewamy pół litra wody na blachę lub do pojemnika i stawiamy na dolnym poziomie) jak i katalitycznie (boki piekarnika pokryte są emalią, która wypala brud).',
 1079.00, 7, 16),
('BEKO', 'BVR35500XMS', 'Pozwala na pieczenie 2 potraw jednocześnie. Posiada 2 małe termoobiegi zamiast jednego dużego, może zostać przedzielone blachą dając imitację 2 niezależnych piekarników. Rozwiązanie świetnie spisuje się przy pieczeniu mniej wymagających potraw o różnych zapachach, lub gdy chcemy zaoszczędzić czas nagrzewając tylko jedną część piekarnika. Na dodatek Beko ma szeroli zakres temperatur jakie możemy ustawić dla obu komór osobno i oferuje to rozwiązanie w połączeniu z większymi komorami pieczenia.',
 1858.00, 7, 17),
('ELECTROLUX', 'EOB8757ZOZ', 'Jeden z najlepszych piekarników parowych na rynku! Urządzenie szwedzkiego producenta wyposażono w 3 tryby pieczenia parowego. „Gotowanie na parze” daje prawie 100% pary i świetnie nadaje się do ryb czy warzyw. „Pieczenie parowe 50/50” służy do odgrzewania, a „pieczenie parowe 25/75” sprawdzi się w pieczeniu mięs.',
 2812.00, 7, 18),
('DE’LONGHI', 'ECAM 23.460.S', 'Model, który można określić mianem „podstawowy”. Zrobi espresso, czarną kawę i kawę z mlekiem (cappuccino, latte). Jest prosty w użyciu, ma dobre parametry techniczne (czyli np. ciśnienie 15 bar, wbudowany młynek żarnowy z regulowaną grubością mielenia, czy zbiornik na wodę o pojemności 1,8 litra). Obsługuje się go za pomocą elektronicznego wyświetlacza i kilku przycisków.',
 2499.00, 8, 19),
('ELDOM', 'WRK1100 Planet', 'Niedrogi i prosty robot kuchenny, oferujący dużą pomoc w przygotowywaniu codziennych posiłków. Doskonale wykonuje takie funkcje, jak m.in. mieszanie, miksowanie, czy ubijanie piany. Jest to też świetny robot do zagniatania ciasta. Posiada siedem wariantów szybkości pracy, więc będziesz mogła dostosowywać ją do zadania, które robot ma wykonać.',
 299.00, 8, 20),
('PHILIPS', 'Avance HR2195/00', 'Philips HR2195/00 to bardzo mocny blender kielichowy o mocy 900W. W połączeniu z aż sześcioma ostrzami tnącymi jest to moc w pełni wystarczająca do szybkiego miksowania wszelkich warzyw (nawet najtwardszych) i owoców (również mrożonych) oraz lodu. Urządzenie daje radę zmielić również orzechy, migdały, a nawet sezam na pastę tahini. Uzyskane koktajle i musy są gładkie i aksamitne, bez grudek.',
 349.00, 8, 21);