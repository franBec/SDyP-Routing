//PM 1 - SDyP
//Franco Becvort - Registro: 3020518 - DNI: 41809105

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 16 //cantidad arbitraria máxima de dimensiones

//struct cadena: contendrá el identificador de un nodo en binario
typedef struct {
	char nodo[MAX];
}cadenas;

//función de routing
void routing(int dimension, char* nodoInicio, char* nodoDestino){

    //variables
    cadenas recorrido[dimension+1]; //arreglo que contiene los nodos que forman el camino
    int cant = 1;
    int i = dimension-1;//como un string finaliza en /0, no voy a ver ese valor
    strcpy(recorrido[0].nodo, nodoInicio); //inserto en el arreglo de cadenas el nodo inicial


	//ITERACIÓN

	//mientras no llegué a destino, itero
    while(strcmp(recorrido[cant-1].nodo, nodoDestino)!=0){

    	//mientras el bit que estoy viendo de mi nodo actual sea igual al bit del nodo al que quiero llegar, itero
        while((recorrido[cant-1].nodo[i]==nodoDestino[i]))
        	i--;

        //duplico el nodo actual en el arreglo
        strcpy(recorrido[cant].nodo, recorrido[cant-1].nodo);

        //ahora al nodo duplicado, le cambio el bit que difiere del nodo actual
        if(recorrido[cant].nodo[i]=='1')
        	recorrido[cant].nodo[i]='0';
        else
        	recorrido[cant].nodo[i]='1';

        cant++; //avanzo en mi arreglo de nodos recorridos

        //ahora el reciente nodo agregado es mi nodo actual en la nueva iteración
    }

    //imprimir nodos
    for (i = 0; i < cant; ++i){
    	printf("Nodo %d : %s\n",i,recorrido[i].nodo);
    }
}

int main(){
    //dvariables
	int dimension;
	char nodoIni[MAX], nodoFin[MAX];

    //ingreso de valores
	printf("Ingrese la dimension del hipercubo: ");
	scanf("%d",&dimension);

	//CONTROL
	while(dimension<0||MAX<dimension){
		printf("Ingrese la dimension del hipercubo nuevamente: ");
		scanf("%d",&dimension);
	}

	printf("Ingrese el nodo de inicio: ");
	scanf("%s",nodoIni);

	//CONTROL
	while(strlen(nodoIni)!=dimension){
		printf("Ingrese el nodo de inicio nuevamente: ");
		scanf("%s",nodoIni);
	}

	printf("Ingrese el nodo de destino: ");
	scanf("%s",nodoFin);

	//CONTROL
	while(strlen(nodoFin)!=dimension){
		printf("Ingrese el nodo de destino nuevamente: ");
		scanf("%s",nodoFin);
	}

    //llamada a la funciónde routing
    routing(dimension, nodoIni, nodoFin);

	system("pause"); //pausa la consola para poder visualizar los resultados
	return 0;
}
