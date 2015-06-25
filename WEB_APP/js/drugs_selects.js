// We extend the Backbone.Model prototype to build our own
var drugModel = Backbone.Model.extend({
  // We can pass it default values.
	defaults : {
		name : ''
	}
});	

var drugCollection = Backbone.Collection.extend({
	model : drugModel,
	url : "api/adsi/1.0/drugs",
	parse : function(response){
		var self = this;
		_.each(response, function(drug){
			self.add(drug);
			$("#drugOption").append("<option id='"+drug.name+"'>"+drug.name+"</option>");
		});
	}
});

var myDrugCollection = new drugCollection;
myDrugCollection.fetch(); // this makes a call to the server and populates the collection based on the response.	

//We extend the Backbone.Model prototype to build our own
var reactionModel = Backbone.Model.extend({
  // We can pass it default values.
	defaults : {
		preferredTerm : ''
	}
});	

var reactionCollection = Backbone.Collection.extend({
	model : reactionModel,
	url : "api/adsi/1.0/reactions",
	parse : function(response){
		var self = this;
		_.each(response, function(reaction){
			self.add(reaction);
			$("#reactionOption").append("<option id='"+reaction.preferredTerm+"'>"+reaction.preferredTerm+"</option>");
		});
	}
});

var myReactionCollection = new reactionCollection;
myReactionCollection.fetch(); // this makes a call to the server and populates the collection based on the response.	
