package com.company;

import java.util.ArrayDeque;

public class Tortue{

    protected String color;
    protected int[] position; //tableau à deux entiers donnant l'abscisse et l'ordonnnée de la tortue sur le plateau
    protected char direction; // nord, sud, est, ouest

    public Tortue(){
        this.position = new int[2];
    }


    public String getColor(){return this.color;}

    public void setColor(String color){this.color = color;}

    public void origin(){
        this.position[0] = 0;
        this.position[1] = 0;
        this.direction = 'N';
    }

    public boolean setPosition(int x, int y){
        if(x >= 0 & x < 8 & y >= 0 & y < 8) { // on vérifie que l'on ne sort  pas du tableau
            this.position[0] = x;
            this.position[1] = y;
            return true;
        }
        else {
            return false;
        }
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public void setPositionDirection(char instruction,Plateau plateau){
        /*met à jour les variables globales de position et de direction en fonction des caractères A, G, D*/

        switch (instruction){
            case 'A': //on avance en prenant en compte la direction
                switch (this.direction){
                    case 'N':
                        if (plateau.isPositionClear(position[0] - 1, position[1])) {
                            position[0] -= 1;
                            setPosition(position[0], position[1]);
                        }
                        break;
                    case 'E':
                        if (plateau.isPositionClear(position[0], position[1]+1)) {
                            position[1] += 1;
                            setPosition(position[0], position[1] );
                        }
                        break;
                    case 'S':
                        if (plateau.isPositionClear(position[0] + 1, position[1])) {
                            position[0] += 1;
                            setPosition(position[0], position[1]);
                        }
                        break;
                    case 'O':
                        if (plateau.isPositionClear(position[0] , position[1] - 1)) {
                            position[1] -= 1;
                            setPosition(position[0], position[1] );
                        }
                        break;

                    default:
                        break;
                }
                break;

            case 'G':

                switch (this.direction){
                    case 'N':
                        setDirection('O');
                        break;
                    case 'S':
                        setDirection('E');
                        break;
                    case 'O':
                        setDirection('S');
                        break;
                    case 'E':
                        setDirection('N');
                        break;
                }
                break;

            case 'D':
                switch (this.direction){
                    case 'N':
                        setDirection('E');
                        break;
                    case 'S':
                        setDirection('O');
                        break;
                    case 'O':
                        setDirection('N');
                        break;
                    case 'E':
                        setDirection('S');
                        break;
                }
                break;

            case 'L':
                switch (this.direction){
                    case 'N':
                        plateau.isICEForLaser(position[0] - 1, position[1]);
                        break;
                    case 'E':
                        plateau.isICEForLaser(position[0] , position[1]+1);
                        break;
                    case 'S':
                        plateau.isICEForLaser(position[0] + 1, position[1]);
                        break;
                    case 'O':
                        plateau.isICEForLaser(position[0], position[1] - 1);
                        break;
                }
                break;

            default:
                System.out.println("Saisie invalide ! ");
                break;
        }
    }

}
