<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fourage.model.*" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forage - Formulaire de demande</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            background: linear-gradient(135deg, #0f172a 0%, #1a2847 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .form-container {
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0 20px 60px rgba(0, 0, 0, 0.3);
            padding: 0;
            max-width: 700px;
            width: 100%;
            overflow: hidden;
            border-top: 4px solid #2563eb;
        }

        .form-header {
            background: linear-gradient(135deg, #1e3a8a 0%, #1e40af 100%);
            color: white;
            padding: 40px 30px;
            text-align: center;
        }

        .form-header h1 {
            font-size: 32px;
            font-weight: 700;
            margin-bottom: 10px;
        }

        .form-header p {
            font-size: 14px;
            opacity: 0.9;
            margin: 0;
        }

        .form-body {
            padding: 40px 30px;
        }

        .alert {
            border-radius: 8px;
            border: none;
            margin-bottom: 25px;
            animation: slideIn 0.3s ease-out;
        }

        .alert-success {
            background-color: #d4edda;
            color: #155724;
        }

        .alert-danger {
            background-color: #f8d7da;
            color: #721c24;
        }

        @keyframes slideIn {
            from {
                opacity: 0;
                transform: translateY(-10px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        .form-section {
            margin-bottom: 35px;
        }

        .form-section:last-of-type {
            margin-bottom: 10px;
        }

        .section-title {
            font-size: 18px;
            font-weight: 600;
            color: #1e40af;
            margin-bottom: 20px;
            display: flex;
            align-items: center;
            padding-bottom: 10px;
            border-bottom: 2px solid #2563eb;
        }

        .section-title i {
            margin-right: 10px;
            font-size: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            font-weight: 600;
            color: #333;
            margin-bottom: 8px;
            font-size: 14px;
            display: block;
        }

        .form-control, .form-select {
            border: 2px solid #e0e0e0;
            border-radius: 6px;
            padding: 12px 15px;
            font-size: 14px;
            transition: all 0.3s ease;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .form-control:focus, .form-select:focus {
            border-color: #2563eb;
            box-shadow: 0 0 0 3px rgba(37, 99, 235, 0.1);
            outline: none;
        }

        .form-control::placeholder {
            color: #999;
        }

        .form-row {
            display: grid;
            grid-template-columns: 1fr;
            gap: 20px;
        }

        @media (max-width: 576px) {
            .form-row {
                grid-template-columns: 1fr;
                gap: 20px;
            }

            .form-header h1 {
                font-size: 24px;
            }

            .form-body {
                padding: 30px 20px;
            }
        }

        .btn-submit {
            background: linear-gradient(135deg, #1e40af 0%, #1e3a8a 100%);
            border: none;
            color: white;
            padding: 14px 40px;
            font-size: 16px;
            font-weight: 600;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
            transition: all 0.3s ease;
            margin-top: 10px;
        }

        .btn-submit:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(30, 64, 175, 0.3);
            background: linear-gradient(135deg, #2563eb 0%, #1e40af 100%);
        }

        .btn-submit:active {
            transform: translateY(0);
        }

        .form-info {
            background: #eff6ff;
            border-left: 4px solid #2563eb;
            padding: 15px;
            border-radius: 6px;
            margin-bottom: 20px;
            font-size: 13px;
            color: #1e40af;
        }

        .form-info i {
            color: #2563eb;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <a href="${pageContext.request.contextPath}/demande/lister">Liste demandes</a>
    <a href="${pageContext.request.contextPath}/devis/formulaire">Devis</a>
    <a href="${pageContext.request.contextPath}/devis/lister">Liste devis</a>
    <div class="form-container">
        <div class="form-header">
            <h1><i class="bi bi-droplet-fill"></i> Demande de Forage</h1>
            <p>Soumettez votre demande de forage en quelques étapes simples</p>
        </div>

        <div class="form-body">
            <%
                String erreur = (String) request.getAttribute("erreur");
                String succes = (String) request.getAttribute("succes");
                if(erreur != null) { %>
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        <i class="bi bi-exclamation-circle-fill"></i> <%= erreur %>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <% } else if(succes != null) { %>
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        <i class="bi bi-check-circle-fill"></i> <%= succes %>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                <% }

                List<Commune> communes = (List<Commune>) request.getAttribute("communes");
            %>

            <form action="${pageContext.request.contextPath}/demande/ajouter" method="post" novalidate>

                <div class="form-info">
                    <i class="bi bi-info-circle-fill"></i> 
                    Les champs marqués avec <span style="color: #dc2626;">*</span> sont obligatoires
                </div>
                
                <!-- Section Informations Personnelles -->
                <div class="form-section">
                    <div class="section-title">
                        <i class="bi bi-person-fill"></i> Informations Personnelles
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="nom">Nom <span style="color: #dc2626;">*</span></label>
                            <input type="text" id="nom" name="nom" class="form-control" 
                                   placeholder="Entrez votre nom" required>
                        </div>
                        <div class="form-group">
                            <label for="prenom">Prénom <span style="color: #dc2626;">*</span></label>
                            <input type="text" id="prenom" name="prenom" class="form-control" 
                                   placeholder="Entrez votre prénom" required>
                        </div>
                    </div>
                </div>

                <!-- Section Localisation et Date -->
                <div class="form-section">
                    <div class="section-title">
                        <i class="bi bi-geo-alt-fill"></i> Localisation et Date
                    </div>
                    
                    <div class="form-group">
                        <label for="idCommune">Commune <span style="color: #dc2626;">*</span></label>
                        <select name="idCommune" id="idCommune" class="form-select" required>
                            <option value="">- Sélectionnez une commune -</option>
                            <% if(communes != null) { 
                                for(Commune commune : communes) { %>
                                    <option value="<%= commune.getId() %>"><%= commune.getLibelle() %></option>
                            <% }
                            } %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="lieu">Lieu <span style="color: #dc2626;">*</span></label>
                        <input type="text" id="lieu" name="lieu" class="form-control" 
                               placeholder="Entrez le lieu de forage" required>
                    </div>

                    <div class="form-group">
                        <label for="date">Date <span style="color: #dc2626;">*</span></label>
                        <input type="datetime-local" id="date" name="date" class="form-control" required>
                    </div>
                </div>

                <button type="submit" class="btn-submit">
                    <i class="bi bi-send-fill"></i> Envoyer la Demande
                </button>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>