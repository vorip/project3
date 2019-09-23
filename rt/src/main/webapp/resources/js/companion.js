function exit() {
	$("#course").remove();
	location.reload();
}
$(function() {
	$(".detail").click(function() {
		$(this).each(function() {
			var leader = $(this).val();
			$.ajax({
				url:"detail",
				data : {"leader": leader
						},
				success: function(result) {
					$("body").append(result);
					$("#compaList").css("pointer-events","none");
					getMove("course");
				}
			})
		})
	})
	
	function getMove(divId) {
   dragElement(document.getElementById(divId)); 
   function dragElement(elmnt) {  
     var pos1 = 0, pos2 = 0, pos3 = 0, pos4 = 0; 
     if (document.getElementById(divId)) { 
       document.getElementById(divId).onmousedown = dragMouseDown; 
     } else { 
       elmnt.onmousedown = dragMouseDown; 
     } 
     function dragMouseDown(e) { 
       e = e || window.event; 
       e.preventDefault(); 
       pos3 = e.clientX; 
       pos4 = e.clientY; 
       document.onmouseup = closeDragElement; 
       document.onmousemove = elementDrag; 
     }  
     function elementDrag(e) { 
       e = e || window.event; 
       e.preventDefault(); 
       pos1 = pos3 - e.clientX; 
       pos2 = pos4 - e.clientY; 
       pos3 = e.clientX; 
       pos4 = e.clientY; 
       elmnt.style.top = (elmnt.offsetTop - pos2) + "px"; 
       elmnt.style.left = (elmnt.offsetLeft - pos1) + "px"; 
     } 
     function closeDragElement() { 
       document.onmouseup = null; 
       document.onmousemove = null;  
     }
   }
}
})