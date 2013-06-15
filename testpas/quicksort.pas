program quicksort;
#define TOTAL_NUM 3
#define ASCII_0 48
var
    a                           :array[1..TOTAL_NUM] of integer;
    i                           :integer;
  


procedure readnum(var num:integer);
var
	i			:integer;
	flag			:integer;
begin
	flag:=0;
	num:=0;
	readln(i);
	while i<>10 do begin
		if i=45 then begin
			flag:=1-flag;
		end 
		else begin
			num:=num*10+i-ASCII_0;
		end;
		readln(i);
	end;
	if flag=1 then
		num:=-num;
end;

procedure printnum(num:integer);
var
	a		:array[1..20] of integer;
	i,k		:integer;
begin
	if (num<0) then begin
		writeln(45); //'-'
		num:=-num;
	end;
	k:=1;
	while (num<>0) do begin
		a[k]:=num mod 10;
		k:=k+1;
		num:=num div 10;
	end;
	for i:=k-1 downto 1 do
		writeln(a[i]+ASCII_0);
end;

procedure quicksort(l,r:integer);
var
    i,j,mid,tmp:integer;
begin
    i:=l;
    j:=r;
mid:=a[l];
    repeat
        while a[i]<mid do i:=i+1;
        while a[j]>mid do j:=j-1;
        if i<=j then begin
            tmp:=a[i];a[i]:=a[j];a[j]:=tmp;
            i:=i+1;
            j:=j-1;
        end;
    until i>j;
    if l<j then quicksort(l,j);
    if i<r then quicksort(i,r);
end;



begin
	for i:=1 to TOTAL_NUM do begin
		readnum(&a[i]);
	end;
    quicksort(1,TOTAL_NUM);
    writeln(83,111,114,116,101,100,58,10);//print "Sorted:\n"
    for i:=1 to TOTAL_NUM do begin
        printnum(a[i]);
        writeln(10);
    end;
end.
