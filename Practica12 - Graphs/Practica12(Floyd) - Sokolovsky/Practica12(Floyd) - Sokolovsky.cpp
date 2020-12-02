#include<stdio.h>

#define V 8
#define INF 99999

void printSolution(int dist[][V])
{
    printf("Following matrix shows the shortest distances"
        " between every pair of vertices \n");
    for (int i = 0; i < V; i++)
    {
        for (int j = 0; j < V; j++)
        {
            if (dist[i][j] == INF)
                printf("%7s", "INF");
            else
                printf("%7d", dist[i][j]);
        }
        printf("\n");
    }
}

void floydWarshall(int graph[][V])
{
    int dist[V][V], i, j, k;

    /* Initialize the solution matrix same as input graph matrix. Or
       we can say the initial values of shortest distances are based
       on shortest paths considering no intermediate vertex. */
    for (i = 0; i < V; i++)
        for (j = 0; j < V; j++)
            dist[i][j] = graph[i][j];

    for (k = 0; k < V; k++)
        for (i = 0; i < V; i++)
        {
            for (j = 0; j < V; j++)
            {
                if (dist[i][k] + dist[k][j] < dist[i][j])
                    dist[i][j] = dist[i][k] + dist[k][j];
            }
        }
    printSolution(dist);
    }

int main()
{
    int graph[V][V] = { {0,   23,  12, INF,   INF, INF, INF},   //1 строка
                        {23, 0,   25, INF,   22, INF, INF, 35}, //2
                        {12, 25, 0,   18,   INF, INF, INF,INF}, //3
                        {INF, INF, 18, 0,  INF,  20, INF,INF},  //4
						{INF,   22,  INF, INF, 0, 23, 14,INF},  //5
                        {INF, INF,  INF, 20, 23, 0, 24,INF},    //6
                        {INF, INF, INF,   INF, 14, 24, 0, 16},  //7
                        {INF, 35, INF, INF, INF, INF, 16, 0},   //8



    	
    };

    floydWarshall(graph);
    return 0;
}