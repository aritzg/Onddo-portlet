var popup=null;
function popUp(url,title,width, heigth, modal){
	
	AUI().use('aui-dialog', function(A){
		popup = new A.Dialog(
				{
					centered: true,
					height: heigth,
					title: title,
					width: width,
					modal: modal
				}
			).render();	
		popup.plug(
				A.Plugin.IO,
				{
					uri: url
				}
			);
	});
}


function refreshElementWithServedResourceNoParse(elementId, resourceURL){
	var r;
	AUI().use('aui-io-request', function(A){
		A.io.request(resourceURL , {
	  		on: {
		   		success: function() {
					targetElement = document.getElementById(elementId); 
					targetElement.innerHTML=this.get('responseData');
		   		}
	  		}
		});
	});
}

function refreshElementWithServedResource(elementId, resourceURL){
	AUI().use('aui-io-request', function(A){
		var node = A.one('#'+elementId);
		node.empty();
		node2 =A.Node.create('<div/>');
		node2.plug(A.Plugin.IO, { uri: resourceURL, method: 'GET', showLoading:true });
		node2.appendTo('#'+elementId);
	});
}