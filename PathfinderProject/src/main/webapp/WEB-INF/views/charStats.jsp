<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<t:layout current="charStats">
	<jsp:attribute name="title">Character Stats</jsp:attribute>
	<jsp:body>
		<c:choose>
        	<c:when test="${userId == null}">
        		<h1>Please login</h1>
        	</c:when>
        	<c:otherwise>
    		    <c:choose>
    		    	<c:when test="${characters.size() > 0}">
			            <h2>Choose Character</h2>
			            <div style="margin-top: 20px">
				            <form action="charStats" method="POST">
				            	<div class="form-gruppe">
				            		<select name="name">
					            		<c:forEach var="character" items="${characters}">
											<option>${character.getName()}</option>
										</c:forEach>
			            			</select>
				            	</div>
				            	<div class="form-gruppe">
				            		<input type="submit" class="button" value="Show Stats">
				            	</div>
				            </form>
				        </div>
				        <div>
				            <div class="green-box">
				                <h2>Character Attributes</h2>
				                <table>
				                    <thead>
				                        <tr>
				                            <th>Attribute</th>
				                            <th>Value</th>
				                            <th>Mod</th>
				                            <th>Temp value</th>
				                            <th>Temp Mod</th>
				                        </tr>
				                    </thead>
				                <tbody>
				                    <tr>
				                        <td>STR</td>
				                        <td>${statsCharacter.getStr()}</td>
				                        <td>${statsCharacter.getSTR_mod()}</td>
				                        <td>${statsCharacter.getSTR_temp()}</td>
				                        <td>${statsCharacter.getSTR_temp_mod()}</td>
				                    </tr>
				                    <tr>
				                        <td>DEX</td>
				                        <td>${statsCharacter.getDex()}</td>
				                        <td>${statsCharacter.getDEX_mod()}</td>
				                        <td>${statsCharacter.getDEX_temp()}</td>
				                        <td>${statsCharacter.getDEX_temp_mod()}</td>
				                    </tr>
				                    <tr>
				                        <td>CON</td>
				                        <td>${statsCharacter.getCon()}</td>
				                        <td>${statsCharacter.getCON_mod()}</td>
				                        <td>${statsCharacter.getCON_temp()}</td>
				                        <td>${statsCharacter.getCON_temp_mod()}</td>
				                    </tr>
				                    <tr>
				                        <td>INT</td>
				                        <td>${statsCharacter.getInte()}</td>
				                        <td>${statsCharacter.getINT_mod()}</td>
				                        <td>${statsCharacter.getINT_temp()}</td>
				                        <td>${statsCharacter.getINT_temp_mod()}</td>
				                    </tr>
				                    <tr>
				                        <td>WIS</td>
				                        <td>${statsCharacter.getWis()}</td>
				                        <td>${statsCharacter.getWIS_mod()}</td>
				                        <td>${statsCharacter.getWIS_temp()}</td>
				                        <td>${statsCharacter.getWIS_temp_mod()}</td>
				                    </tr>
				                    <tr>
				                        <td>CHA</td>
				                        <td>${statsCharacter.getCha()}</td>
				                        <td>${statsCharacter.getCHA_mod()}</td>
				                        <td>${statsCharacter.getCHA_temp()}</td>
				                        <td>${statsCharacter.getCHA_temp_mod()}</td>
				                    </tr>
				                </tbody>
				            </table>
				        </div>
				            <div class="green-box">
				            <h2>Character health stats</h2>
				            <table>
				                <thead>
				                    <tr>
				                        <th>MAX HP</th>
				                        <th>Damage taken</th>
				                        <th>NL damage</th>
				                        <th>DR</th>
				                    </tr>
				                </thead>
				                <tbody>
				                    <tr>
				                        <td>13</td>
				                        <td>0</td>
				                        <td>3</td>
				                        <td>0</td>
				                    </tr>
				                </tbody>
				            </table>
				        </div>
				            <div class="green-box">
				                <h2>Movement stats</h2>
				                <table>
				                    <thead>
				                        <tr>
				                            <th></th>
				                            <th>Meter</th>
				                            <th>Fields</th>
				                        </tr>
				                    </thead>
				                    <tbody>
				                        <tr>
				                            <td>Land</td>
				                            <td>9</td>
				                            <td>6</td>
				                        </tr>
				                        <tr>
				                            <td>Land wa</td>
				                            <td>9</td>
				                            <td>6</td>
				                        </tr>
				                        <tr>
				                            <td>climbing</td>
				                            <td>9</td>
				                            <td>6</td>
				                        </tr>
				                        <tr>
				                            <td>Swimming</td>
				                            <td>9</td>
				                            <td>6</td>
				                        </tr>
				                        <tr>
				                            <td>Flying</td>
				                            <td>9</td>
				                            <td>6</td>
				                        </tr>
				                        <tr>
				                            <td>digging</td>
				                            <td>9</td>
				                            <td>6</td>
				                        </tr>
				                    </tbody>
				                </table>
				            </div>
				        </div>
				        <div>
				            <div class="green-box" style="width: 100%">
				                <h2>Combat Stats</h2>
				                <table>
				                    <thead>
				                       <tr>
				                            <th>AC</th>
				                            <th>= 10 + </th>
				                            <th>AC Bonus + </th>
				                            <th>Shield Bonus + </th>
				                            <th>DEX mod + </th>
				                            <th>Height mod + </th>
				                            <th>Natural Armor + </th>
				                            <th>Distraction Bonus + </th>
				                            <th>Other Bonus</th>
				                       </tr>
				                    </thead>
				                    <tbody>
				                       <tr>
				                            <td>15</td>
				                            <td></td>
				                            <td>5</td>
				                            <td>0</td>
				                            <td>0</td>
				                            <td>0</td>
				                            <td>0</td>
				                            <td>0</td>
				                            <td>0</td>
				                       </tr>
				                    </tbody>
				                </table>
				                <table>
				                    <thead>
				                        <tr>
				                            <th>CMB = </th>
				                            <th>BAB + </th>
				                            <th>STR Mod + </th>
				                            <th>Height Mod + </th>
				                            <th>Other Bonus</th>
				                        </tr>
				                    </thead>
				                    <tbody>
				                        <tr>
				                            <td>3</td>
				                            <td>0</td>
				                            <td>0</td>
				                            <td>0</td>
				                            <td>0</td>
				                        </tr>
				                    </tbody>
				                </table>
				                <table>
				                    <thead>
				                        <tr>
				                            <th>CMD = </th>
				                            <th>BAB + </th>
				                            <th>STR Mod + </th>
				                            <th>Height Mod + </th>
				                            <th>DEX Mod + </th>
				                            <th>10</th>
				                        </tr>
				                    </thead>
				                    <tbody>
				                        <tr>
				                            <td>12</td>
				                            <td>1</td>
				                            <td>1</td>
				                            <td>1</td>
				                            <td>1</td>
				                        </tr>
				                    </tbody>
				                </table>
				                <table>
				                    <thead>
				                        <tr>
				                            <th>INI = </th>
				                            <th>DEX Mod + </th>
				                            <th>Other Mod</th>
				                        </tr>
				                    </thead>
				                    <tbody>
				                        <tr>
				                            <td>3</td>
				                            <td>3</td>
				                            <td>4</td>
				                        </tr>
				                    </tbody>
				                </table>
				                <table>
				                    <thead>
				                        <tr>
				                            <th>Will = </th>
				                            <th>Base bonus + </th>
				                            <th>WIS Mod + </th>
				                            <th>Magic Mod + </th>
				                            <th>Other Mod + </th>
				                            <th>Temp Mod</th>
				                        </tr>
				                    </thead>
				                    <tbody>
				                        <tr>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                        </tr>
				                    </tbody>
				                </table>
				                <table>
				                    <thead>
				                        <tr>
				                            <th>Reflex = </th>
				                            <th>Base bonus + </th>
				                            <th>DEX Mod + </th>
				                            <th>Magic Mod + </th>
				                            <th>Other Mod + </th>
				                            <th>Temp Mod</th>
				                        </tr>    
				                    </thead>
				                    <tbody>
				                        <tr>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                        </tr>
				                    </tbody>
				                </table>
				                <table>
				                    <thead>
				                        <tr>
				                            <th>Fortitude = </th>
				                            <th>Base bonus + </th>
				                            <th>CON Mod + </th>
				                            <th>Magic Mod + </th>
				                            <th>Other Mod + </th>
				                            <th>Temp Mod</th>
				                        </tr>
				                    </thead>
				                    <tbody>
				                        <tr>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                            <td>34</td>
				                        </tr>
				                    </tbody>
				                </table>
				            </div>
				        </div>
    		    	</c:when>
    		    	<c:otherwise>
    		    		<h1>Please create a character</h1>
    		    	</c:otherwise>
    		    </c:choose>
        	</c:otherwise>
        </c:choose>
	</jsp:body>
</t:layout>

        
