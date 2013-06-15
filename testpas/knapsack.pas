program knapsack;
#define MAX_ITEM_NUM 10
#define MAX_KNAPSACK_SIZE 100
#define ASCII_0 48
type
	item=record
		w	:integer; //weight
		v	:integer; //value
	end;

var
	itemarray	:array[1..MAX_ITEM_NUM] of item;
	f			:array[1..MAX_KNAPSACK_SIZE] of integer;
	n,m,i,j		:integer;

procedure readnum(var num:integer);
var
	i			:integer;
begin
	num:=0;
	readln(i);
	while (i<>10) and (i<>32) do begin
		num:=num*10+i-ASCII_0;
		readln(i);
	end;
end;

procedure readitem(var it:item);
begin
	readnum(&it.w); //read weight
	readnum(&it.v); //read value
end;

procedure printnum(num:integer);
var
	a		:array[1..20] of integer;
	i,k		:integer;
begin
	k:=1;
	while (num<>0) do begin
		a[k]:=num mod 10;
		k:=k+1;
		num:=num div 10;
	end;
	if k=1 then
		k:=k+1; //write 0
	for i:=k-1 downto 1 do
		writeln(a[i]+ASCII_0);
end;

function maxnum(a,b:integer):integer;
begin
	if a>b then
		maxnum:=a
	else
		maxnum:=b;
end;


begin
	readnum(&n); //read item num
	readnum(&m); //read knapsack size
	for i:=1 to n do begin
		readitem(&itemarray[i]);
	end;

	for i:=m downto 0 do begin
		f[i]:=0;
	end;
	for i:=1 to n do
		for j:=m downto 0 do begin
			if j>=itemarray[i].w then begin
				f[j]:=maxnum(f[j],f[j-itemarray[i].w]+itemarray[i].v);
			end;
		end;
	writeln(10);
	printnum(f[m]);
	writeln(10);

end.


