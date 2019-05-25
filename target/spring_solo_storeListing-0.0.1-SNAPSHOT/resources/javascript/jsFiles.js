$(function() {
  $('a[href*="#"]:not([href="#"])').click(function() {
    if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') && location.hostname == this.hostname) {
      var target = $(this.hash);
      target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
      if (target.length) {
        $('html, body').animate({
          scrollTop: target.offset().top
        }, 1000);
        return false;
      }
    }
  });
});

$(document).ready(function(){
  styleForNav();
  editButton();
})

function styleForNav(){
  var $wid= $(window);
  var scrollPostion=$wid.scrollTop();
  $wid.on('scroll', function(){
    var screenTop=$wid.scrollTop()/3;
    if(screenTop>70){
    $('#navigation').addClass('navigationBarStyle');
    }
  else{
    $('#navigation').removeClass('navigationBarStyle');
    }
  })
}

function editButton(){
	$('button').click(function(){
		var divname = $(this).attr('n');
		$('#'+divname).toggle('slow').siblings().hide('slow');
	});
}