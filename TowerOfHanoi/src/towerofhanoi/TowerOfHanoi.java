package towerofhanoi;

import java.util.*;

public class TowerOfHanoi {

    public static Scanner input = new Scanner(System.in);
    public static Stack A = new Stack();
    public static Stack B = new Stack();
    public static Stack C = new Stack();
    public static char lvl, dari, ke;
    public static int NA, NB, NC;

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("=== TOWER OF HANOI ===");
        System.out.println("Selamat datang di permainan Tower of Hanoi");
        level();
        pindah();

    }

    static void level() {
        System.out.print("\nPilih level [E - 3 disks][M - 5 disks][H - 7 disks] : ");
        lvl = input.next().charAt(0);

        if (lvl == 'e') {
            lvl = 'E';
        }
        if (lvl == 'm') {
            lvl = 'M';
        }
        if (lvl == 'h') {
            lvl = 'H';
        }

        switch (lvl) {
            case 'E':
                for (int i = 3; i > 0; i--) {
                    A.push(i);
                }
                break;
            case 'M':
                for (int i = 5; i > 0; i--) {
                    A.push(i);
                }
                break;
            case 'H':
                for (int i = 7; i > 0; i--) {
                    A.push(i);
                }
                break;
            default:
                System.out.println("level tidak tersedia!");
                level();
        }
    }

    static void print() {
        System.out.println("======================================");
        System.out.println("A : " + A);
        System.out.println("");
        System.out.println("B : " + B);
        System.out.println("");
        System.out.println("C : " + C);
        System.out.println("======================================");
    }

    static void pindah() {

        print();

        System.out.print("\nPindah disk dari : ");
        dari = input.next().charAt(0);

//ignore case
        if (dari == 'a' || dari == 'A') {
            dari = 'A';
        } else if (dari == 'b' || dari == 'B') {
            dari = 'B';
        } else if (dari == 'c' || dari == 'C') {
            dari = 'C';
        } else {
            System.out.println("Pilihan tidak valid, ulangi");
            pindah();
        }
        System.out.print("ke : ");
        ke = input.next().charAt(0);
        if (ke == 'a' || ke == 'A') {
            ke = 'A';
        } else if (ke == 'b' || ke == 'B') {
            ke = 'B';
        } else if (ke == 'c' || ke == 'C') {
            ke = 'C';
        } else {
            System.out.println("Pilihan tidak valid, ulangi");
            pindah();
        }

//exception case 
        if (dari == ke) {
            System.out.println("tidak bisa memasukan Huruf yang sama, ulangi!");
            pindah();
        }

//pindah
        if (dari == 'A') {
            if (A.isEmpty() == false) {
                NA = (int) A.peek();
            }

            if (A.isEmpty() == true) {
                System.out.println("Tower A kosong, ulangi");
                pindah();
            } else if (ke == 'B') {
                if (B.isEmpty() == true) {
                    B.push(A.pop());
                } else {
                    NB = (int) B.peek();
                    if (NA > NB) {
                        System.out.println("gagal, angka " + A.peek() + " lebih besar dari " + B.peek());
                        pindah();
                    } else if (NA < NB) {
                        B.push(A.pop());
                    }
                }
            } else if (ke == 'C') {
                if (C.isEmpty() == true) {
                    C.push(A.pop());
                } else {
                    NC = (int) C.peek();
                    if (NA > NC) {
                        System.out.println("gagal, angka " + A.peek() + " lebih besar dari " + C.peek());
                        pindah();
                    } else if (NA < NC) {
                        C.push(A.pop());
                    }
                }
            } 
        } else if (dari == 'B') {

            if (B.isEmpty() == false) {
                NB = (int) B.peek();
            }

            if (B.isEmpty() == true) {
                System.out.println("Tower B kosong, ulangi");
                pindah();
            } else if (ke == 'A') {
                if (A.isEmpty() == true) {
                    A.push(B.pop());
                } else {
                    NA = (int) A.peek();
                    if (NB > NA) {
                        System.out.println("gagal, angka " + B.peek() + " lebih besar dari " + A.peek());
                        pindah();
                    } else if (NB < NA) {
                        A.push(B.pop());
                    }
                }
            } else if (ke == 'C') {
                if (C.isEmpty() == true) {
                    C.push(B.pop());
                } else {
                    NC = (int) C.peek();
                    if (NB > NC) {
                        System.out.println("gagal, angka " + B.peek() + " lebih besar dari " + C.peek());
                        pindah();
                    } else if (NB < NC) {
                        C.push(B.pop());
                    }
                }
            } 
        } else if (dari == 'C') {
            if (C.isEmpty() == false) {
                NC = (int) C.peek();
            }
            if (C.isEmpty() == true) {
                System.out.println("Tower C kosong, ulangi");
                pindah();
            } else if (ke == 'B') {
                if (B.isEmpty() == true) {
                    B.push(C.pop());
                } else {
                    NB = (int) B.peek();
                    if (NC > NB) {
                        System.out.println("gagal, angka " + C.peek() + " lebih besar dari " + B.peek());
                        pindah();
                    } else if (NC < NB) {
                        B.push(C.pop());
                    }
                }
            } else if (ke == 'A') {
                if (A.isEmpty() == true) {
                    A.push(C.pop());
                } else {
                    NA = (int) A.peek();
                    if (NC > NA) {
                        System.out.println("gagal, angka " + C.peek() + " lebih besar dari " + A.peek());
                        pindah();
                    } else if (NC < NA) {
                        A.push(C.pop());
                    }
                }
            } 
        } 

        if (A.isEmpty() == true && B.isEmpty() == true) {
            System.out.println("game selesai!");
        } else {
            pindah();
        }

    }
}
