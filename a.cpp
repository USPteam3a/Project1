#include <iostream>
#include <string>

using namespace std;

class A {
    int a;
    string txt;
public:
    A(){
        a=0;
        txt= "";
    }

    A(int a1, string  txt1)
    {
        a=a1;
        txt=txt1;
    }

    void print()
    {
        cout << a << " " << txt << "\n";
    }
}

void main()
{
    cout << "Branch2" << endl;
    A obj;
    A obj2 (3, "abv" );
    obj2.print();
}