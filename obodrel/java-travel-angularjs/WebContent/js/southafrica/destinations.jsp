			<p>These are all the destinations :</p>
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>City Name</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>
					<tr data-ng-repeat="value in vm.destinationsArray">
						<td><a href="./southafrica/#!/destinations/{{value.id}}">{{value.id}}</a></td>
						<td><a href="./southafrica/#!/destinations/{{value.id}}">{{value.name}}</a></td>
						<td><a href="./southafrica/#!/destinations/{{value.id}}">{{value.description}}</a></td>
					</tr>
				</tbody>
			</table>