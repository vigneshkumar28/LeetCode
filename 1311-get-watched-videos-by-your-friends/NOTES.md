bfs notes:
//bfs - add in q and check size, pop and travel it
// find id = 1,2 example 1 using q via bfs
// count freq based on q's value which is 0's connected value C:2, B:1
//sort C:2, B:1 and lexographical sort also needs to do
//freq are diff - return a1-b1 else b1-a1
​
custom comparator
​
result.sort((a,b)->{
int a1 = freqMap.get(a);
int b1 = freqMap.get(b);
if(a1!=b1){
//freq different
return a1-b1;
}else{
// lexographic, freq are same
return a.compareTo(b);
}
});