var cartApp = angular.module("cartApp", [])

cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function () {
        $http.get("/VideoTarzan/rest/cart/" + $scope.cartId).success(function (data) {
            $scope.cart = data;
            $scope.grandTotal = $scope.calGrandTotal();
        });
    };

    $scope.clearCart = function () {
        $http.delete("/VideoTarzan/rest/cart/" + $scope.cartId).success(function () {
            $scope.refreshCart();
        });
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart();
    };

    $scope.addToCart = function (movieId) {
        $http.put("/VideoTarzan/rest/cart/add/" + movieId).success(function () {
            alert("Movie successfully added to the cart!");
        });
    };

    $scope.removeFromCart = function (movieId) {
        $http.put("/VideoTarzan/rest/cart/remove/" + movieId).success(function () {
            $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function () {
        var grandTotal = 0;

        for (var i = 0; i < $scope.cart.cartItems.length; i++) {
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }

});