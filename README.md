# 🔁 Asana-Trello Integration API

## 📌 About the Project
This project is an automation API that synchronizes task data between Trello and Asana. It serves as a middleware to facilitate real-time or scheduled synchronization of task information, helping teams manage workflows across platforms efficiently.

## 💡 Features
- Extract tasks (cards) from Trello
- Create corresponding tasks in Asana
- Map fields between the platforms
- JSON-based configuration and authentication
- Simple scheduling (via cron or manual trigger)

## 🛠️ Technologies Used
- Python 3
- Flask
- Requests (HTTP Client)
- Trello API
- Asana API

## 📁 Folder Structure
```
├── main.py
├── asana_utils.py
├── trello_utils.py
├── config.json
├── requirements.txt
```

## 🚀 Getting Started
1. Clone the repository
2. Create your `config.json` with Trello and Asana API keys and project info
3. Install dependencies and run

```bash
git clone https://github.com/Lucasvdalves/api_asana_trello.git
cd api_asana_trello
pip install -r requirements.txt
python main.py
```

## 🧪 Sample JSON Config
```json
{
  "trello_key": "YOUR_TRELLO_KEY",
  "trello_token": "YOUR_TRELLO_TOKEN",
  "asana_token": "YOUR_ASANA_TOKEN",
  "asana_project_id": "YOUR_PROJECT_ID"
}
```

## 🎯 Future Improvements
- Bi-directional sync (Asana → Trello)
- Webhook support for real-time updates
- Enhanced logging and error handling
- Dashboard for monitoring sync jobs

## 📄 License
MIT License
