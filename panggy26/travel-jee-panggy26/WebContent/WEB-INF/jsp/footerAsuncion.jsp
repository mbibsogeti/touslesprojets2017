<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h2>Texte issu de footerAsuncion</h2>
<p>La cité abrite le musée Godoi, le musée del Barro conservant l', l'église de l'Incarnation et le Panthéon national d'Asunción inspiré
	des Invalides à Paris, où de nombreux héros de la nation sont inhumés.</p>
<!-- On récupère ce paramètre year dans Asuncion. Si le nom n'est pas year, la valeur prend 2017 -->
<p>${(param.year != null) ? param.year : 2017}</p>