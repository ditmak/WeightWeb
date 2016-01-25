$(function(){
	var weightInput =$("#weightInput");
	var weightSubmit=$("#weightSubmit");
	weightSubmit.click(function(){
		var data = weightInput.val();
		$.ajax({
			url:"/WeightWeb/recordWeight.chtml",
			data:{
				"weight":weightInput.val()
			},
			success:function(data){
				console.log(data);
			}
		});
	});
});