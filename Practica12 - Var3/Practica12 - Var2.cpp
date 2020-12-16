#include <iostream>
#include <fstream>
#include <sstream>
using namespace std;
#pragma warning(disable : 4996) //Visual Studio ругается на fopen
struct Person
{
	string Number;
	string Address;
	string Name;
	Person(string n, string a, string name)
	{
		Number = n;
		Address = a;
		Name = name;
	}
};

int main()
{
	//Вводим двух людей
	Person Alex("12345", "Moscow", "Alex");
	Person Valya("67890", "Ulan-ude", "Valya");
	//Записываем их данные в текстовый файл
	fstream tOut("text.txt", ios::out);
	tOut<< Alex.Number <<" "<< Alex.Address<<" "<< Alex.Name<<endl;
	tOut << Valya.Number <<" "<< Valya.Address<<" " << Valya.Name;
	tOut.close();

	
	//Получаем данные из текстового файла, включая пробелы и переносы строки,
	//и затем преобразовываем строку в массив char'ов
	//чтобы использовать его как аргумент для записи в бинарный файл
	fstream tIn("text.txt", ios::in);
	stringstream buffer; //сюда вносим строку с пробелами и переносами
	buffer << tIn.rdbuf();
	tIn.close();
	string contents(buffer.str()); //в эту строку переносим содержание buffer'а
	const char* ch = contents.c_str(); //и теперь строку в массив char'ов

	
	//Записываем содержимое text.txt, хранящееся в ch, в binary.dat
	FILE* f;
	f = fopen("binary.dat", "w");
	fwrite(ch, 1, strlen(ch), f);
	fclose(f);
	
	system("binary.dat");
	
}

// Запуск программы: CTRL+F5 или меню "Отладка" > "Запуск без отладки"
// Отладка программы: F5 или меню "Отладка" > "Запустить отладку"

// Советы по началу работы 
//   1. В окне обозревателя решений можно добавлять файлы и управлять ими.
//   2. В окне Team Explorer можно подключиться к системе управления версиями.
//   3. В окне "Выходные данные" можно просматривать выходные данные сборки и другие сообщения.
//   4. В окне "Список ошибок" можно просматривать ошибки.
//   5. Последовательно выберите пункты меню "Проект" > "Добавить новый элемент", чтобы создать файлы кода, или "Проект" > "Добавить существующий элемент", чтобы добавить в проект существующие файлы кода.
//   6. Чтобы снова открыть этот проект позже, выберите пункты меню "Файл" > "Открыть" > "Проект" и выберите SLN-файл.
