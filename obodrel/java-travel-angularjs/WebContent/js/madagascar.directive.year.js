angular.module("application")
	.directive("year",yearDirective);

function yearDirective() {
	return {
		restrict : "EA",
		template : new Date().getFullYear()
	};
}
