/*
학생객체를 생성해서 반환해주는 <<< 함수 >>> 작성
*/
var com=new Object();
com.itwill=new Object();
com.itwill.Student = function (id,name,kor,eng,math){
	this.id=id;
	this.name=name;
	this.kor=kor;
	this.eng=eng;
	this.math=math;
	this.tot=0;
	this.avg=0.0;
};

/************prototype[JSON]******************/
com.itwill.Student.prototype={
		'calculateTot':function(){
			this.tot=this.kor+this.eng+this.math;
		},
		'calculateAvg':function(){
			this.avg=this.tot/3;
		},
		'toString':function(){
			return '['+this.id+']'+this.name+','+this.kor+','+this.eng+','+this.math+','+this.tot+','+this.avg;
		}
};