#include <iostream>
#include <string>

using namespace std;

class B {
    int b;
    string txt;
public:
    B(){
        a=0;
        txt= "";
    }

    B(int b1, string  txt1)
    {
        b=b1;
        txt=txt1;
    }

    void print()
    {
        cout << b << " " << txt << "\n";
    }
}

void main()
{
    B obj;
    B obj2 (3, "abv" );
    obj2.print();
}