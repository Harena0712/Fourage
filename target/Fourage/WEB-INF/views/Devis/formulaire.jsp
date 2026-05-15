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
            max-width: 1500px;
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
            padding: 56px 50px;
        }

        .form-layout {
            display: grid;
            grid-template-columns: 0.7fr 1.3fr;
            gap: 36px;
            align-items: start;
        }

        #details-container {
            width: 100%;
        }

        .detail-row {
            background: #f8fafc;
            border: 1px solid #e5e7eb;
            border-radius: 10px;
            padding: 16px 14px 8px;
        }

        .detail-row .form-label {
            font-size: 13px;
            margin-bottom: 6px;
        }

        .detail-row .form-control,
        .detail-row .detail-total {
            min-height: 44px;
        }

        .detail-row .col-md-5 {
            flex: 0 0 auto;
            width: 56%;
        }

        .detail-row .col-md-4 {
            flex: 0 0 auto;
            width: 48%;
        }

        .detail-row .col-md-2 {
            flex: 0 0 auto;
            width: 15%;
        }

        .detail-row .col-md-3 {
            flex: 0 0 auto;
            width: 20%;
        }

        .detail-row .col-md-1 {
            flex: 0 0 auto;
            width: 6%;
        }

        .detail-row .col-md-4,
        .detail-row .col-md-3,
        .detail-row .col-md-2,
        .detail-row .col-md-1 {
            padding-left: 10px;
            padding-right: 10px;
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
            .form-layout {
                grid-template-columns: 1fr;
            }

            .form-container {
                max-width: 100%;
            }

            .form-row {
                grid-template-columns: 1fr;
                gap: 20px;
            }

            .form-header h1 {
                font-size: 24px;
            }

            .form-body {
                padding: 32px 18px;
            }

            .detail-row .col-md-4,
            .detail-row .col-md-3,
            .detail-row .col-md-2,
            .detail-row .col-md-1 {
                width: 100%;
                padding-left: 12px;
                padding-right: 12px;
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

        /* Improved sidebar */
        .sidebar {
            position: fixed;
            left: 24px;
            top: 40px;
            width: 260px;
            height: calc(100vh - 80px);
            background: linear-gradient(180deg,#0b1226 0%,#12263f 100%);
            color: #fff;
            border-radius: 12px;
            box-shadow: 0 20px 50px rgba(2,6,23,0.6);
            padding: 16px;
            z-index: 1050;
            overflow: auto;
        }
        .sidebar .brand { display:flex; align-items:center; justify-content:space-between; margin-bottom:12px; }
        .sidebar .brand a { color:#fff; text-decoration:none; display:flex; align-items:center; gap:10px; }
        .sidebar .brand .brand-logo { font-size:22px; background:rgba(255,255,255,0.06); padding:8px; border-radius:8px; }
        .sidebar .brand .brand-text { font-weight:700; font-size:18px; }
        .sidebar .nav-link { display:flex; align-items:center; gap:10px; color:rgba(255,255,255,0.92); padding:10px 12px; border-radius:8px; margin-bottom:8px; text-decoration:none; }
        .sidebar .nav-link:hover { background:rgba(255,255,255,0.04); color:#fff; }
        .sidebar .nav-link.active { background:rgba(255,255,255,0.06); box-shadow: inset 4px 0 0 0 rgba(255,255,255,0.14); font-weight:700; }
        .sidebar .sidebar-footer { margin-top:16px; font-size:12px; opacity:0.8; }
        .sidebar .sidebar-toggle { background:transparent; border:none; color:#fff; font-size:20px; }

        .main-with-sidebar { margin-left: 320px; padding-top: 20px; }
        .overlay { display:none; }
        .overlay.show { display:block; position:fixed; inset:0; background:rgba(0,0,0,0.45); z-index:1040; }

        @media (max-width: 900px) {
            .sidebar { transform: translateX(-110%); transition: transform .25s ease-in-out; left: 0; top: 0; height: 100vh; border-radius: 0; }
            .sidebar.open { transform: translateX(0); }
            .main-with-sidebar { margin-left: 0; }
            .sidebar .sidebar-toggle { display:inline-block; }
        }
    </style> 
</head>
<body>
    <div class="page">
        <aside class="sidebar" role="navigation">
            <div class="brand">
                <a href="${pageContext.request.contextPath}/">
                    <span class="brand-logo"><i class="bi bi-receipt"></i></span>
                    <span class="brand-text">Forage</span>
                </a>
                <button class="sidebar-toggle" aria-label="Ouvrir le menu"><i class="bi bi-list"></i></button>
            </div>

            <nav class="nav flex-column">
                <p>Formulaire</p>
                <a class="nav-link" href="${pageContext.request.contextPath}/demande/formulaire"><i class="bi bi-file-earmark-text"></i> Demande</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/devis/formulaire"><i class="bi bi-file-earmark-text"></i> Devis</a>
                <p>Liste</p>
                <a class="nav-link" href="${pageContext.request.contextPath}/demande/lister"><i class="bi bi-card-list"></i> Liste demandes</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/devis/lister"><i class="bi bi-receipt"></i> Liste devis</a>
            </nav>
            
            <div class="sidebar-footer">v1.0 • Forage</div>
        </aside>

        <main class="main-with-sidebar">
            <div class="form-container">
        <div class="form-header">
            <h1><i class="bi bi-droplet-fill"></i> Devis pour un forage</h1>
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

                List<Demande> demandes = (List<Demande>) request.getAttribute("demandes");
                List<Type> types = (List<Type>) request.getAttribute("types");
            %>

            <form action="${pageContext.request.contextPath}/devis/ajouter" method="post" novalidate>

                <div class="form-info">
                    <i class="bi bi-info-circle-fill"></i> 
                    Les champs marqués avec <span style="color: #dc2626;">*</span> sont obligatoires
                </div>
                
                <div class="form-layout">
                    <div class="form-section">
                        <div class="section-title">
                            <i class="bi bi-file-earmark-text-fill"></i> Devis
                        </div>

                        <div class="form-group">
                            <label for="idDemande">Demande <span style="color: #dc2626;">*</span></label>
                            <select name="idDemande" id="idDemande" class="form-select" required>
                                <option value="">- Sélectionnez une Demande -</option>
                                <% if(demandes != null) { 
                                    for(Demande demande : demandes) { %>
                                        <option value="<%= demande.getId() %>"><%= demande.getReference() %></option>
                                    <% }
                                } %>
                            </select>
                            <div id="info-demande" class="mt-3 d-none">
                                <p><strong>Client :</strong> <span id="client"></span></p>
                                <p><strong>Date :</strong> <span id="date"></span></p>
                                <p><strong>Lieu :</strong> <span id="lieu"></span></p>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="desc">Description <span style="color: #dc2626;">*</span></label>
                            <textarea id="desc" name="desc" class="form-control" 
                                      placeholder="Entrez la description du travail" required></textarea>
                        </div>

                        <div class="form-group">
                            <label for="type">Type du devis <span style="color: #dc2626;">*</span></label>
                                <% if(types != null) {
                                    for(Type type : types) { %>
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" id="type_<%= type.getId() %>" name="idType" value="<%= type.getId() %>" required>
                                            <label class="form-check-label" for="type_<%= type.getId() %>"><%= type.getLibelle() %></label>
                                        </div>
                                    <% }
                                } %>
                        </div>

                        <div class="form-group">
                            <label for="daty">Date <span style="color: #dc2626;">*</span></label>
                            <input type="datetime-local" id="daty" name="daty" class="form-control" required>
                        </div>
                    </div>

                    <div class="form-section">
                        <div class="section-title">
                            <i class="bi bi-calendar-event-fill"></i> Details du devis
                        </div>

                        <div id="details-container">
                            <div class="detail-row row g-3 align-items-end mb-3">
                                <div class="col-12 col-md-4">
                                    <label class="form-label">Libelle <span style="color: #dc2626;">*</span></label>
                                    <input type="text" name="libelle[]" class="form-control detail-libelle" placeholder="Libellé" required>
                                </div>

                                <div class="col-6 col-md-2">
                                    <label class="form-label">Quantité <span style="color: #dc2626;">*</span></label>
                                    <input type="number" name="qnt[]" class="form-control detail-qnt" placeholder="Qté" min="1" required>
                                </div>

                                <div class="col-6 col-md-2">
                                    <label class="form-label">Prix Unitaire <span style="color: #dc2626;">*</span></label>
                                    <input type="number" name="PU[]" class="form-control detail-pu" placeholder="PU" step="0.01" min="0" required>
                                </div>

                                <div class="col-8 col-md-2">
                                    <label class="form-label">Montant</label>
                                    <output class="form-control detail-total d-flex align-items-center" style="background:#f8fafc;"></output>
                                </div>

                                <div class="col-4 col-md-1 text-end d-flex align-items-end justify-content-end h-100">
                                    <button type="button" class="btn btn-outline-danger btn-sm detail-remove d-none" aria-label="Supprimer la ligne">&times;</button>
                                </div>
                            </div>
                        </div>

                        <div class="d-flex justify-content-end gap-2 mb-3">
                            <button type="button" id="add-detail" class="btn btn-outline-primary btn-sm">
                                <i class="bi bi-plus-circle"></i> Ajouter une autre ligne
                            </button>
                        </div>

                        <div class="form-group">
                            <label for="total">Montant total</label>
                            <p id="total" class="fw-bold mb-0"></p>
                        </div>
                    </div>
                </div>

                <div class="mt-4">
                    <button type="submit" class="btn-submit">
                        <i class="bi bi-send-fill"></i> Enregistrer le devis
                    </button>
                </div>
            </form>
        </div>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            document.getElementById("idDemande").addEventListener("blur", trouveInfoDemande);
            document.getElementById("add-detail").addEventListener("click", ajouterLigneDetail);
            document.getElementById("details-container").addEventListener("input", recalculerDetails);
            document.getElementById("details-container").addEventListener("click", function (event) {
                if (event.target.classList.contains("detail-remove")) {
                    event.target.closest(".detail-row").remove();
                    recalculerDetails();
                }
            });
            recalculerDetails();
        });

        function ajouterLigneDetail() {
            const container = document.getElementById("details-container");
            const prototype = container.querySelector(".detail-row");
            const nouvelleLigne = prototype.cloneNode(true);

            nouvelleLigne.querySelectorAll("input").forEach(function (input) {
                input.value = "";
            });
            nouvelleLigne.querySelector("output").textContent = "";
            nouvelleLigne.querySelector(".detail-remove").classList.remove("d-none");

            container.appendChild(nouvelleLigne);
            recalculerDetails();
        }

        function recalculerDetails() {
            const lignes = document.querySelectorAll(".detail-row");
            let totalGeneral = 0;

            lignes.forEach(function (ligne) {
                const qnt = parseFloat(ligne.querySelector(".detail-qnt").value) || 0;
                const pu = parseFloat(ligne.querySelector(".detail-pu").value) || 0;
                const montant = qnt * pu;

                ligne.querySelector(".detail-total").textContent = montant ? montant.toFixed(2) : "";
                totalGeneral += montant;
            });

            document.getElementById("total").textContent = totalGeneral ? totalGeneral.toFixed(2) : "";
        }

        function trouveInfoDemande() {

            let idDemande = document.getElementById("idDemande").value;
            let infoDemande = document.getElementById("info-demande");

            let client = document.getElementById("client");
            let date = document.getElementById("date");
            let lieu = document.getElementById("lieu");

            if (!idDemande) {
                infoDemande.classList.add("d-none");
                client.innerText = "";
                date.innerText = "";
                lieu.innerText = "";
                return;
            }

            fetch('${pageContext.request.contextPath}/devis/infoDemande', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: 'idDemande=' + idDemande
            })
            .then(response => response.json())
            .then(data => {
                if(data.success) {
                    client.innerText = data.client;
                    date.innerText = data.date;
                    lieu.innerText = data.lieu;
                    infoDemande.classList.remove("d-none");
                } else {
                    infoDemande.classList.add("d-none");
                    client.innerText = "";
                    date.innerText = "";
                    lieu.innerText = "";
                }
            })
            .catch(error => {
                infoDemande.classList.add("d-none");
                client.innerText = "";
                date.innerText = "";
                lieu.innerText = "";
                console.log(error);
            });
        }
    </script>

    <script>
        (function(){
            var sidebar = document.querySelector('.sidebar');
            var toggle = document.querySelector('.sidebar-toggle');
            var overlay = document.createElement('div'); overlay.className = 'overlay';
            document.body.appendChild(overlay);

            function closeSidebar(){ sidebar.classList.remove('open'); overlay.classList.remove('show'); }
            function openSidebar(){ sidebar.classList.add('open'); overlay.classList.add('show'); }

            if(toggle){ toggle.addEventListener('click', function(){ sidebar.classList.toggle('open'); overlay.classList.toggle('show'); }); }
            overlay.addEventListener('click', closeSidebar);

            // mark active link
            var links = document.querySelectorAll('.sidebar .nav-link');
            var path = window.location.pathname || '';
            var ctx = '${pageContext.request.contextPath}';
            links.forEach(function(a){
                var href = a.getAttribute('href') || '';
                var rel = href.replace(ctx, '');
                if(rel && path.indexOf(rel) !== -1){ a.classList.add('active'); }
            });
        })();
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

