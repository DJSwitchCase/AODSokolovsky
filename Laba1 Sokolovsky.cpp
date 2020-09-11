#include <iostream>
#include <queue>
#include <vector>
using namespace std;
void showarray(vector <int> &array1)
{
	cout << "Массив выглядит как: " << endl;
	for (int i = 0; i < array1.size(); i++)
	{
		cout << array1[i] << " ";
	}
	cout << endl;
}
void sortarray(vector <int> &array1, int mod)
{
	for (int i = 0; i < array1.size(); i++)
		for (int j = 1; j < array1.size(); j++)
			if ((array1[j - 1] % mod) > (array1[j] % mod)) //возр или уменьш
				swap(array1[j - 1], array1[j]);
}

int main()
{
	setlocale(0, "");
	int n = 0; int k = 0;
	vector <vector <int>> vec;
	vec.resize(5);
	vector <int> vecboss;
	for (int i = 0; i < 5; i++)
		for (int j = 0; j < 1; j++)
		{
			cout << "Добавляйте элемент в " << i+1 << " массив" << endl;
			cin >> n;
			vec[i].push_back(n);
		}

	for (int i = 0; i < 5; i++)
	{
		vecboss.reserve(vecboss.size() + vec[i].size());
		vecboss.insert(vecboss.end(), vec[i].begin(), vec[i].end());
	}

	showarray(vecboss);
	sortarray(vecboss, 10);
	sortarray(vecboss, 100);
	sortarray(vecboss, 1000);
	showarray(vecboss);
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
