let index = {
		init: function() {
			$("#btn-save").on("click", ()=>{
				this.save();
			});
			
			$("#historyBack").on("click", ()=>{
				this.back();
			});
			
			$("#btn-delete").on("click", ()=>{
				this.deletById();
			});
			
			$("#btn-update").on("click", ()=>{
				this.update();
			});
		},
		save: function() {
			let data= {
				title: $("#title").val(),
				content: $("#content").val()
			};
			
			$.ajax({
				type: "POST",
				url: "/api/board",
				data: JSON.stringify(data), 
				contentType: "application/json; charset=utf-8", 
				dataType: "json"
			}).done(function(resp){
				alert("글쓰기가 완료되었습니다.");
				location.href = "/";				
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		back: function() {
			history.back();
		},
		deletById: function() {
			let id = $("input[name='boardId']").val();
			
			$.ajax({
				type: "DELETE",
				url: "/api/board/" + id,
				dataType: "json"
			}).done(function(resp){
				alert("삭제가 완료되었습니다.");
				location.href = "/";				
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		},
		update: function() {
			
			let id = $("input[name='updateId']").val();
			
			let data= {
				title: $("input[name='updateTitle']").val(),
				content: $("textarea[name='updateContent']").val()
			};
			
			$.ajax({
				type: "PUT",
				url: "/api/board/"+id,
				data: JSON.stringify(data), 
				contentType: "application/json; charset=utf-8", 
				dataType: "json"
			}).done(function(resp){
				alert("글수정이 완료되었습니다.");
				location.href = "/";				
			}).fail(function(error){
				alert(JSON.stringify(error));
			}); 
		}
}

index.init();