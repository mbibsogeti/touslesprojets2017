			<p data-ng-if="vm.setDestinationById()">You chose to go to {{vm.currDestination.name}}, here is some explanations of the 
			location : {{vm.currDestination.description}}</p>
			<p data-ng-if="!vm.setDestinationById()">There is no destination mapped to the number you typed, try to use or tools to 
			discover our trips destinations!</p>