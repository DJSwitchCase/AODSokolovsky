#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <clocale>
#include <iostream>

int main()
{
	//Метод Дейкстры
    setlocale(0, "");
    const int SIZE = 6;
    int array_of_nodes[SIZE][SIZE]; // матрица связей
    int min_distance[SIZE]; // минимальное расстояние
    int visited_nodes[SIZE]; // посещенные вершины
    int temp, minindex, min;
    int begin_index = 0;
    // Инициализация матрицы связей
    for (int i = 0; i < SIZE; i++)
    {
        array_of_nodes[i][i] = 0;
        for (int j = i + 1; j < SIZE; j++) 
        {
            printf("Введите расстояние %d - %d: ", i + 1, j + 1);
        	scanf("%d", &temp);
            array_of_nodes[i][j] = temp;
            array_of_nodes[j][i] = temp;
        }
    }
    //Вывод матрицы связей
    for (int i = 0; i < SIZE; i++)
    {
        for (int j = 0; j < SIZE; j++)
            printf("%10d", array_of_nodes[i][j]);
        printf("\n");
    }
    //Инициализация вершин и расстояний
    for (int i = 0; i < SIZE; i++)
    {
        min_distance[i] = 10000;
        visited_nodes[i] = 1;
    }
    min_distance[begin_index] = 0;
    //Шаг алгоритма
    do {
        minindex = 10000;
        min = 10000;
        for (int i = 0; i < SIZE; i++)
        { // Если вершину ещё не обошли и вес меньше min
            if ((visited_nodes[i] == 1) && (min_distance[i] < min))
            { // Переприсваиваем значения
                min = min_distance[i];
                minindex = i;
            }
        }
        // Добавляем найденный минимальный вес
        // к текущему весу вершины
        // и сравниваем с текущим минимальным весом вершины
        if (minindex != 10000)
        {
            for (int i = 0; i < SIZE; i++)
            {
                if (array_of_nodes[minindex][i] > 0)
                {
                    temp = min + array_of_nodes[minindex][i];
                    if (temp < min_distance[i])
                    {
                        min_distance[i] = temp;
                    }
                }
            }
            visited_nodes[minindex] = 0;
        }
    } while (minindex < 10000);
    // Вывод кратчайших расстояний до вершин
    printf("\nКратчайшие расстояния до вершин: \n");
    for (int i = 0; i < SIZE; i++)
        printf("%5d ", min_distance[i]);

    // Восстановление пути
    int ver[SIZE]; // массив посещенных вершин
    int end = 4; // индекс конечной вершины = 5 - 1
    ver[0] = end + 1; // начальный элемент - конечная вершина
    int k = 1; // индекс предыдущей вершины
    int weight = min_distance[end]; // вес конечной вершины

    while (end != begin_index) // пока не дошли до начальной вершины
    {
        for (int i = 0; i < SIZE; i++) // просматриваем все вершины
            if (array_of_nodes[i][end] != 0)   // если связь есть
            {
                int temp = weight - array_of_nodes[i][end]; // определяем вес пути из предыдущей вершины
                if (temp == min_distance[i]) // если вес совпал с рассчитанным
                {                 // значит из этой вершины и был переход
                    weight = temp; // сохраняем новый вес
                    end = i;       // сохраняем предыдущую вершину
                    ver[k] = i + 1; // и записываем ее в массив
                    k++;
                }
            }
    }
    // Вывод пути (начальная вершина оказалась в конце массива из k элементов)
    printf("\nВывод кратчайшего пути\n");
    for (int i = k - 1; i >= 0; i--)
        printf("%3d ", ver[i]);
    getchar(); getchar();
    return 0;
}
