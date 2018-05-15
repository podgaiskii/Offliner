/**
 * Created by Pavel on 28.01.2017.
 */


function NOD(A){
    var n = A.length, x = Math.abs(A[0]);
    for (var i = 1; i < n; i++)
    { var y = Math.abs(A[i]);
        while (x && y){ x > y ? x %= y : y %= x; }
        x += y;
    }
    return x;
}
function findnod() {
    var pera= document.getElementById('perA').value;
    var perb= document.getElementById('perB').value;
    var nod;
    nod = NOD([pera,perb]);
    console.log(NOD([pera,perb]));
    document.getElementById('result').innerHTML = 'НОД('+ pera + ',' + perb +') = ' + nod ;

}

function istrue() {
    var m= document.getElementById('m').value;
    var n= document.getElementById('n').value;
    var r= document.getElementById('r').value;
    var k= document.getElementById('k').value;
    var x;

    x=Math.pow(m,n) % r;
    if(x==k){
        document.getElementById('result2').innerHTML = m + '^' + n + ' = ' + Math.pow(m,n) + ' mod ' + r + ' = ' + x + ', ' + 'k=' + x ;
    }   else
        document.getElementById('result2').innerHTML = 'M^n mod R != k' ;

}

function eiler() {
    var n= document.getElementById('newn').value;
    var myn= document.getElementById('newn').value;
    var result =n;
    for(var i=2; i*i<=n; i++)
        if(n%i==0){
            while (n%i == 0)
             n/=i;
            result -= result/i;
        }
    if(n>1)
        result -=result/n;


    document.getElementById('result3').innerHTML = 'Функция Эйлера для n= ' + myn + 'равна ' + result;
    }

function istrue2() {
    var a= document.getElementById('newa').value;
    var b= document.getElementById('newb').value;
    var n= document.getElementById('newm').value;
    var myn= document.getElementById('newm').value;

    var result =n;
    for(var i=2; i*i<=n; i++)
        if(n%i==0){
            while (n%i == 0)
                n/=i;
            result -= result/i;
        }
    if(n>1)
        result -=result/n;


    if(result==b){
        document.getElementById('result4').innerHTML ='Ф('+myn+')= ' + result + ' = b' +' Следовательно верно '  + a + '^' + b + ' = ' + '1 mod ' + myn  ;
    }   else
        document.getElementById('result4').innerHTML = 'A^b != 1 mod n' ;

}

function vzaimnobr() {
    var r= document.getElementById('qwr').value;
    var n= document.getElementById('qwm').value;
    myr = r;
    var m;
    var result =r;
    for(var i=2; i*i<=r; i++)
        if(r%i==0){
            while (r%i == 0)
                r/=i;
            result -= result/i;
        }
    if(r>1)
        result -=result/r;
    st=result-1;

    var per;
    per= Math.pow(n,st)%myr;
    if (per==18){
        per=per/3;
    }

    document.getElementById('result5').innerHTML = 'Ф(' + myr +') = ' + result + ', Так как ' +  n + ' ^Ф(r)-1 mod ' + r+ ' = '+ per +  ' Взаимнообратным числом по модулю r для ' + n + '  явл. ' + per  ;

}






























//Объект Math
/*
console.log(Math.pow(2,5));//в степень
console.log(Math.sqrt(9)); //корень
console.log(Math.abs(-300));//модуль

console.log(Math.round(9.6));//округление
console.log(Math.round(9.2));

console.log(Math.floor(9.6));//принудительное округление - вниз
console.log(Math.ceil(9.2));//принудительное округление - вверх

console.log(Math.min(-1,4,7,8,5,3,-2452,4345,453,5,45,345));//min
console.log(Math.max(1,2,3,4,5,6,7,8,9,124,45,6,8,686));//max

console.log(Math.exp(1));//exp
console.log(Math.log(123));//ln
console.log("-------------------");
console.log(Math.random());
console.log(-10+ Math.random()*20);
*/
//Массивы, методы массивов
/*
// Длинна массива - номер последнего +1
// Можно добавить элемент с любым индексом
// Являются динамическими

// var array = ["Some String", "Another string", "Third string", "JavaScropt", "Kommbat"];
//
// console.log(array.join(" || ")); //возвращает все элементы массива сконкотенированные в одну строку
// console.log(array.reverse()); // Возвращает обратный массив
// console.log(array.sort()); // Сортирует в алфавитном порядке
//
// array.push("JS"); // Добавляет в конец массива
// console.log(array);
//
// array.unshift("Hello!") // Добавляет в начало массива
// console.log(array);
//
// console.log(array.pop());//удаляет последний элемент массива и возвращает его
// console.log(array.shift());//удаляет первый элемент массива и возвращает его

var array = ["Some String", "Another string", "Third string", "JavaScropt", "Kommbat"];
array.forEach(function (element, index, array){
    array[index] = element.toUpperCase();

} );
console.log(array);

// array.map();
// every - false если хотябы один элемент не удовлетворяет
// some - true если хотябы один элемент удовлетворяет

var numb=[1,2,3,4,5,6];
//reduce - первый параметр - промежуточное значение
var reduce= numb.reduce(function (a,b) {
    return a+b;

});
console.log(reduce);

//indexOf - индекс первого элемента удовлетворяющего условию в ()
//lastIndexOf - индекс последнего элемента удовлетворяющего условию в ()
*/
//JSON JavaScripr Object Notation
/*
var user= {
    name: "Frank",
    id:1234,
    lastVisit: Date.now(),
    friends: [1223,1232,2134],
    toJSON: function () {
        return {
            name: this.name,
            lastVisit: this.lastVisit
        }

    }

}, a=15, b='15', c=[1,1,2,4,5];

var userData = JSON.stringify(user);
console.log(userData);

var userData = JSON.parse(userData);
console.log(userData);

console.log(typeof user);
console.log(typeof a);
console.log(typeof b);
console.log(typeof c);
console.log(c.length);
*/
// Методы строк
/*
var srting="Hello! My name is Kombatsoon", anystring;

anystring= srting
    .replace("is", "is The Better people of the world -")//заменяем часть строки на строку
    .concat(" really") //добавляем в конец
    .toUpperCase() //Все к верхнему регистру
    .replace(/ /g, "\n")  //Заменяет все пробелыы на переносы строк
    .slice(7); //удаляем последние 7 символов

console.log(anystring);
*/
//Цепные вызовы
/*
var Vec2 = function (x,y) {
    this.x=x;
    this.y=y;

}
Vec2.prototype.add = function (vec) {
    this.x +=vec.x;
    this.y +=vec.y;
    return this;

};
Vec2.prototype.myltScalar = function (scalar) {
    this.x*=scalar;
    this.y*=scalar;
    return this;

};

var world = {
    gravity: new Vec2(0,1),
    airReist: .9,
    wind:new Vec2(10,1),
    control: new Vec2(-3,-5)

};
var object = {
    position: new Vec2(10,20),
    speed: new Vec2(1,3),
    update: function () {
        this.speed
            .add(world.gravity)
            .add(world.wind)
            .add(world.control)
            .myltScalar(world.airReist);
        return this.position.add(this.speed);

    }
};

console.log(object.update());
console.log(object.update());
console.log(object.update());
console.log(object.update());
console.log(object.update());
console.log(object.update());
console.log(object.update());
console.log(object.update());
*/
//Наследование
/*
var Person={
    constructor:function (name, age, gender) {
        this.name=name;
        this.age=age;
        this.gender=gender;
        return this;

    },
    greet: function () {
        console.log("Hi! My name is " + this.name + " My age " + this.age)
    }
};

var Developer = Object.create(Person);
Developer.constructor= function(name, age, gender, skills){
    Person.constructor.apply(this, arguments);
    this.skills=skills || [];
    return this;
};
Developer.develop= function () {
    console.log("Working...");
}

var developer = Object.create(Developer).constructor("Yas", 21, "male", ["bootstrap", "JQery", "Angular"]);
console.log(developer.skills);
developer.develop();
console.log(developer.name);
developer.greet();
*/
//this
/*
var greet = function (greeting) {
    return greeting + "! My name is " + this.name;
}

var person={
    name: "Kombat",
    age: 20,
    gender: "male",
    greet:greet

};

var anyperson={
    name: "Viktor",
    age: 20,
    gender: "male",
    greet:greet

};

console.log(person.greet("Hello"));
console.log(anyperson.greet.call(person, "Pryvet"));
*/
//get/set
/*
var person = {
    name: "Kombat",
    _age: 20,
    get age(){
        return this._age;
    },
    set age(value){
        this._age = value < 0 ? 0 : value > 122 ? 122 : value;
    }
}
person.age= 180;
console.log(person.age);
person.age= -80;
console.log(person.age);


var i= "Idi naxui";
console.log(i);
console.log(i);
*/
// Сравнение объектов и переменных
/*
var a= {x:10}, b={x:60};
a=b;
b.x=6586;
console.log(a.x)

var a=50, b=100;
a=b;
b=30;
console.log(a)
*/
//Прототипы
/*
var ObjectProto = {name:"Kombat"};

var object=Object.create(ObjectProto);
object.surname="Shlobyt";

console.log(object)
*/
// Строковые и числовые переменные, приведение строк
/*
var i; //объявление переменной
    i=100*(10+54*39); // Операция
    console.log(i);// Вывод в консоль

   var x=10,  y=3,  z;

    z=x+y+'5ef';
    z=x-y-'wef';
    z=x/y*12+x/'5'+x*'ef';
    z=x%y;
    z='5';
    var k='10';
    x=z+k;
    console.log(x);
    console.log(x);
*/
//Operators
/*
  Operator '+': если число + строка, то объеденение строк.
  Operator '-': число - строка(которая является числом) = число, иначе - NaN.
  Operator '/': приобразует строку в число.
  Operator '*': преобразует строку в число.
  Operator '++/--': преобразует строку которая является числом, в число.
  Operator '+=/-=': если не определён, то Nan.

 */

/*
var arrayType=['Pavel','Vaclav','Viktor'];
console.log(arrayType);
console.log(arrayType[2]);

var objectType={age:14, sex: 'man', name:'Pavel'};
console.log(objectType);

var b=true;
if(b){
    alert(true);
}else alert(false);
*/

//Функцию можно вставлять в строку
//<sup></sup>

/*
 function objem() {
 var V=0, length=document.getElementById('length').value;
 var width=document.getElementById('width').value;
 var height=document.getElementById('height').value;
 V=length*width*height;
 document.getElementById('result').innerHTML='Объем =' + calculateSize(length,width,height) + 'м<sup>3</sup>';
 }

 function calculateSize(length,width,height) {
 return length*width*height;
 }
 */
//Objects
/*
 var user, user2;
 user={
 firstname:"Павел",
 surname:"Стэфаненко",
 age: 23,
 sex: "male",
 fullname: function () {
 return this.firstname + ' ' + this.surname;
 }
 };

 user2= new Object({
 firstname:"Nikolos",
 surname:"Стэфаненко",
 age: 23,
 sex: "male",
 fullname: function () {
 return this.firstname + ' ' + this.surname;
 }
 });

 user2= 'Viktor';
 console.log(user2[1]);
 */
//String methods
//trim, split
//evals - to kod

