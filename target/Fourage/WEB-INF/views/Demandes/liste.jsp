<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fourage.model.*" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forage - Liste des demandes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { background: linear-gradient(135deg,#0f172a 0%,#1a2847 100%); min-height:100vh; font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; }
        .form-container { background:#fff; border-radius:12px; box-shadow:0 20px 60px rgba(0,0,0,.3); padding:0; max-width:1200px; width:100%; margin:40px auto; border-top:4px solid #2563eb; }
        .form-header { background:linear-gradient(135deg,#1e3a8a 0%,#1e40af 100%); color:#fff; padding:24px 30px; border-top-left-radius:12px; border-top-right-radius:12px; }
        .form-header h1{font-size:22px;margin:0}
        .form-body { padding:24px 30px; }
        .table thead th { background:#f1f5f9; }
        .actions { white-space: nowrap; }
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
        .sidebar nav p { margin:12px 0 8px; font-size:12px; color:rgba(255,255,255,0.6); font-weight:700; }

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
            <h1><i class="bi bi-list-check"></i> Liste des demandes</h1>
        </div>

        <div class="form-body">
            <div class="mb-3 d-flex justify-content-between align-items-center">
                <div class="text-muted small">Total: <span id="total-count"></span></div>
            </div>

            <%
                List<Demande> demandes = (List<Demande>) request.getAttribute("demandes");
                List<Client> clients = (List<Client>) request.getAttribute("clients");
                List<Commune> communes = (List<Commune>) request.getAttribute("communes");
            %>

            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Référence</th>
                        <th>Client</th>
                        <th>Commune</th>
                        <th>Lieu</th>
                        <th>Date</th>
                    </tr>
                </thead>
                <tbody>
                <% if (demandes != null) {
                       for (Demande demande : demandes) {
                           String clientName = "-";
                           if (clients != null) {
                               for (Client client : clients) {
                                   if (client.getId() == demande.getIdClient()) {
                                       clientName = client.getNom() + " " + client.getPrenom();
                                       break;
                                   }
                               }
                           }

                           String communeName = "-";
                           if (communes != null) {
                               for (Commune commune : communes) {
                                   if (commune.getId() == demande.getIdCommune()) {
                                       communeName = commune.getLibelle();
                                       break;
                                   }
                               }
                           }
                %>
                    <tr>
                        <td><%= demande.getReference() %></td>
                        <td><%= clientName %></td>
                        <td><%= communeName %></td>
                        <td><%= demande.getLieu() %></td>
                        <td><%= demande.getDaty() %></td>
                    </tr>
                <%   }
                   } else { %>
                    <tr><td colspan="5" class="text-center">Aucune demande trouvée.</td></tr>
                <% } %>
                </tbody>
            </table>
        </div>
            </div>
        </main>
    </div>

    <script>
        // Fill total count
        document.addEventListener('DOMContentLoaded', function () {
            var tbody = document.querySelector('table tbody');
            var count = tbody ? tbody.querySelectorAll('tr').length : 0;
            document.getElementById('total-count').innerText = count;
        });
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